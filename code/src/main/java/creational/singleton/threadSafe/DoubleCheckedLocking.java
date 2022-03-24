package creational.singleton.threadSafe;

class DoubleCheckedLocking {

    private static class Settings {

        private static Settings instance;

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
}
