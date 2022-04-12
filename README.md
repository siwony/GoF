# Gang of Four 디자인 패턴
GoF의 디자인패턴은 `에리히 감마(Erich Gamma)`, `리처드 헬름(Richard Helm)`, `랄프 존슨(Ralph Johnson)`, `존 블리시데스(John Vlissides)`가 소프트웨어 공학에서 가장 많이 사용되는 23개의 패턴을 구체화 한 것이다.

GoF의 디자인 패턴은 목적에 따라 3가지의 패턴으로 분류할 수 있다.
> 생성, 구조, 행동

#### 생성 패턴 - Creational
객체의 생성에 관련된 패턴이다.
- [`추상 팩토리 - Abstract Factory`](doc/creational/abstract-factory-pattern.md)
- `빌더 - Builder`
- [`팩토리 메서드 - Factory Method`](doc/creational/factory-method-pattern.md)
- `프로토타입 - Prototype`
- [`싱글톤 - Singleton`](doc/creational/singleton-pattern.md)

#### 구조 - Structural
클래스나 객체들을 조합해 더 큰 구조로 만들 수 있게 해주는 패턴이다.
- `어댑터 - Adapter`
- `브리지 - Bridge`
- `컴포지드 - Composite`
- `퍼사드 - Facade`
- `플라이웨이트 - Flyweight`
- `프록시 - Proxy`

#### 행위 - Behavioral
객체나 클래스의 교류 방법에 대해 정의한 패턴이다.
- `책임 연쇄 - Chain of Responsibility`
- `커맨드 - Command`
- `인터프리터 - Interpreter`
- `반복자 - Iterator`
- `중재자 - Mediator`
- `메멘토 - Memento`
- `옵저버 - Observer`
- `상태 - State`
- `전략 - Strategy`
- `템플릿 메서드 - Template Method`
- `방문자 - Visitor`

이 Repository는 백기선님의 [코딩으로 학습하는 GoF의 디자인 패턴](https://www.inflearn.com/course/디자인-패턴/dashboard)을 기반으로 작성되었습니다.  
그리고 패턴 구현에 초점이 맞춰저 있어 자바의 문법/기능적인 부분이 매우 많이 들어갈 예정입니다.