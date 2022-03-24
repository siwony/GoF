package creational.singleton.threadSafe;

class UseStaticInnerClass {

    private static class Settings {

        private Settings() {}

        private static final class InstanceHolder {
            private static final Settings INSTANCE = new Settings();
        }

        public static Settings getInstance(){
            return InstanceHolder.INSTANCE;
        }
    }
}
