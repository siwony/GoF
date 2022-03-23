package creational.factory_method.threadSafe;

class EagerInitialization {

    private static class Settings {

        private static final Settings INSTANCE = new Settings();

        private Settings() {}

        public static Settings getInstance(){
            return INSTANCE;
        }
    }
}
