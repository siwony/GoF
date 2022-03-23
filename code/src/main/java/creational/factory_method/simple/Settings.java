package creational.factory_method.simple;

class Settings {

    private static Settings instance;

    private Settings() {}

    public static Settings getInstance(){
        if(instance == null)
            instance = new Settings();

        return instance;
    }
}
