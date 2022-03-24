package creational.singleton.simple;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SettingsTest {

    @Test
    public void settingsTest(){
        Settings settings = Settings.getInstance();

        assertEquals(settings, Settings.getInstance());
    }

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

        Thread.sleep(1500);
        Settings settings1 = settingsList.get(0);
        Settings settings2 = settingsList.get(1);
        Settings settings3 = settingsList.get(2);

        assertEquals(settings1, settings2);
        assertEquals(settings2, settings3);
    }

}