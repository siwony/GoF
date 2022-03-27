package creational.singleton.defense_reflection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class DefenceReflectionAndSerializationAndDeserializeTest {


    //IllegalArgumentException가 발생하면 정상이다.
    @Test
    public void defenceReflectionTest() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Settings settings = Settings.INSTANCE;

        Settings settingsReflection = null;
        final Constructor<Settings> constructor = Settings.class.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);

        settingsReflection = constructor.newInstance("INSTANCE");

        Assertions.assertNotEquals(settings, settingsReflection);
    }

    @Test
    public void useSerializeAndDeserialize() throws IOException, ClassNotFoundException {
        Settings settings = Settings.INSTANCE;

        Settings serializeAndDeserializeSettings = null;

        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("settings.obj"))){
            out.writeObject(settings);
        }

        try(ObjectInput in = new ObjectInputStream(new FileInputStream("settings.obj"))){
            serializeAndDeserializeSettings = (Settings) in.readObject();
        }

        assertEquals(settings, serializeAndDeserializeSettings);
    }

}