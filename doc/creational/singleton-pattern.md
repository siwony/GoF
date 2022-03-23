# 싱글톤 패턴 - singleton pattern
> 인스턴스를 오직 한개만 제공하는 클래스

인스턴스를 오직 한개만 만들어 제공하는 클래스가 필요할 때 사용한다.
- 환경세팅에 대한 정보, 시스템 런타임 등...

## 1. 싱글톤 패턴을 가장 단순히 구현하는 방법
> 소스코드: [Settings.java](../../code/src/main/java/creational/factory_method/simple/Settings.java)  
> 테스트 코드: [SettingsTest.java](../../code/src/test/java/creational/factory_method/simple/SettingsTest.java)

```java
class Settings{

    private static Settings instance;
    
    private Settings(){} // 외부에서 객체를 생성하면 안되기 때문에 private으로 생성자를 만든다.

    public static Settings getInstance(){
        if (instance == null)
            instance = new Settings();

        return instance;
    }
}
```
- 생성자를 private로 만들어 외부에서 객체를 생성할 수 없도록 막았다.
- `getInstance()`를 이용해 외부에서 객체를 받을 수 있다.

junit으로 `Settings.getInstance`가 계속 같은 객체를 반환하는지 테스트 코드를 작성해보면 통과하는 것을 확인할 수 있다.
```java
@Test
public void settingsTest(){
    Settings settings = Settings.getInstance();
    
    assertEquals(settings, Settings.getInstance());
}
```
하지만 이 방법은 단순한 만큼 단점이 존재하는데 멀티 스레드 환경에서는 안전하지 않다.

#### 왜 멀티 스레드 환경에서 안전하지 않을까?
두개의 스레드가 거의 동시에 `getInstance()`를 호출했다고 가정하면,  
if문 속 `instance = new Settings()`가 두 번 호출될 것이고 결과적으로 객체가 2개 생성된다.

이를 테스트 코드로 작성하면
```java
@Test
public void multiThreadTest() throws InterruptedException {
    List<Settings> settingsList = new ArrayList<>();

    Thread a = new Thread(
            () -> settingsList.add(Settings.getInstance())
    );
    Thread b = new Thread(
            () -> settingsList.add(Settings.getInstance())
    );
    Thread c = new Thread(
            () -> settingsList.add(Settings.getInstance())
    );

    a.start();
    b.start();
    c.start();

    Thread.sleep(1000);
    Settings settings1 = settingsList.get(0);
    Settings settings2 = settingsList.get(1);
    Settings settings3 = settingsList.get(2);

    assertEquals(settings1, settings2);
    assertEquals(settings2, settings3);
}
```
1. a, b, c스레드는 모두 `getInstance()`를 호출하여 얻은 `Settings`객체를 `settingsList`에 저장한다.
2. List에 데이터를 제대로 저장하기 위해 메인스레드를 1초 멈춘다.
3. 그리고 `settingsList`의 0, 1, 2번째에 저장된 객체가 같은지 확인한다.

**해당 테스트는 상황에 따라 성공할 수 있고 실패할 수 있다.** 그러므로 멀티 스레드 환경에서 안전하지 않다는 것을 확인할 수 있다.

예시.
<img src="img/singleton-non-thread-safe.png">

## 2. 멀티 스레드 환경에서 안전하게 구현하는 방법
### 2-1. 이른 초기화 - Eager Initialization
> 소스코드 위치 : [EagerInitialization.java](../../code/src/main/java/creational/factory_method/threadSafe/EagerInitialization.java)

객체 생성 비용이 적은 경우에 사용한다.
```java
class Settings {

    private static final Settings INSTANCE = new Settings();

    private Settings() {}

    public static Settings getInstance(){
        return INSTANCE;
    }
}
```
- 클레스가 로드되는 시점에 객체가 생성되므로 런타임 시점에서 `thread-safe`하다.

하지만...  
**사용하지 않은 객체를 미리 생성할 수 있으므로 리소스의 낭비될 수 있다.**

### 2-2. `getInstance()`에 synchronized 키워드 사용하기
> 소스코드 위치 : [UseSynchronizedKeyword.java](../../code/src/main/java/creational/factory_method/threadSafe/UseSynchronizedKeyword.java)
```java
class Settings{

    private static Settings instance;
    
    private Settings(){} 

    public static synchronized Settings getInstance(){
        if (instance == null)
            instance = new Settings();

        return instance;
    }
}
```
자바의 `synchronized`키워드를 추가한 `getInstance()`를 호출하면 해당 메서드에 `락 - rock`을 걸어 **처음 접근한 쓰레드 이외의 다른 스레드가 접근할 수 없도록 하여** `thread-safe`한 싱글톤 객체를 만들 수 있다.

하지만...  
**`getInstance()`를 호출할 때 매번 락이 걸리므로 성능상 그렇게 좋지는 않다.**

### 2-3. Double Checked Locking 사용하기
> 소스코드 위치 : [DoubleCheckedLocking.java](../../code/src/main/java/creational/factory_method/threadSafe/DoubleCheckedLocking.java)
`synchronized`블럭 전에 한번 체크하고 `synchronized`후에 한번 더 체크하는 방법이라 Double Checked Locking이라고 불린다.

```java
class Settings {

    private static volatile Settings instance;

    private Settings() {}

    public static Settings getInstance(){
        if(instance == null){
            synchronized (Settings.class) {
                if(instance == null){
                    instance = new Settings();
                }
            }
        }
        return instance;
    }
}
```
`getInstance()`에 synchronized 키워드를 사용한 방법보다 Double Checked Locking방법이 효율적이다. 그 이유는 
- 매번 호출할 때 락이 걸리는 것이 아닌 instance가 null이 아닐 때 만 락이 걸리므로 [2-2](#2-2-getinstance에-synchronized-키워드-사용하기)방법 보다 효율적이다.

하지만...  
- 코드가 복잡해진다.
- 코드가 복잡한 만큼 이 코드의 동작 원리도 복잡하다.
  > instance 전역 변수에 `volatile`키워드를 사용했는지에 대한 이유를 이해 하려면 Java1.4이하 버전이 메모리/멀티스테드를 다루는 방법에 대해 알아야 한다.
- 해당 코드는 Java1.5 부터 동작한다.

### 2-4. static inner class 사용하기
> 소스코드 위치 : [UseStaticInnerClass.java](../../code/src/main/java/creational/factory_method/threadSafe/UseStaticInnerClass.java)
```java
class Settings {
    
    private Settings() {}

    private static final class InstanceHolder {
        private static final Settings instance = new Settings();
    }

    public static Settings getInstance(){
        return InstanceHolder.instance;
    }
}
```
static inner class는 호출하는 시점에 로딩이 되는 성질을 이용해 싱글톤을 구현할 수 있다.

## 3. 이러한 싱글톤 패턴을 무너뜨리는 방법 - Reflection
