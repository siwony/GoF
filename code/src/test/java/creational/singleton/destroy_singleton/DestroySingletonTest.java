package creational.singleton.destroy_singleton;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * 싱글톤을 무너트리는 방법
 */
class DestroySingletonTest {

    // 리플렉션 사용하기
    @Test
    public void useReflection() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        final Settings settings = Settings.getInstance();

        final Constructor<Settings> settingsConstructor = Settings.class.getDeclaredConstructor();
        settingsConstructor.setAccessible(true);
        Settings reflectionSettings = settingsConstructor.newInstance();

        assertNotEquals(settings, reflectionSettings);
    }

    /**
     * {@link Settings#readResolve()}로 인해 해당 테스트는 실패한다. <br>
     * (성공하고 싶다면 {@link Settings#readResolve()}를 제거한다.)
     */
    @Test
    public void useSerializeAndDeserialize() throws IOException, ClassNotFoundException {
        Settings settings = Settings.getInstance();

        Settings serializeAndDeserializeSettings = null;

        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("settings.obj"))){
            out.writeObject(settings);
        }

        try(ObjectInput in = new ObjectInputStream(new FileInputStream("settings.obj"))){
            serializeAndDeserializeSettings = (Settings) in.readObject();
        }

        assertNotEquals(settings, serializeAndDeserializeSettings);
    }
}