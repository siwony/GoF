package structural.facade._02_after;

import java.util.Properties;

public class MailPropertiesMaker {

    public Properties makeProperties(final String host){
        final Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        return properties;
    }
}
