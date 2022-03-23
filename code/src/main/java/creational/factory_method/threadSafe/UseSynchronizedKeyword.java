package creational.factory_method.threadSafe;

public class UseSynchronizedKeyword {

    private static class Settings {

        private static Settings instance;

        private Settings() {}

        public static Settings getInstance(){
            if(instance == null)
                instance = new Settings();

            return instance;
        }
    }

}
