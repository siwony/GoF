package creational.singleton.destroy_singleton;

import java.io.Serializable;

/**
 * 싱글톤 객체를 무너트리는 방법의 예시 클래스 <br>
 * DestroySingletonTest 확인
 */
class Settings implements Serializable {

    private Settings() {}

    private static final class InstanceHolder {
        private static final Settings INSTANCE = new Settings();
    }

    public static Settings getInstance(){
        return Settings.InstanceHolder.INSTANCE;
    }

    protected Object readResolve(){
        return getInstance();
    }
}