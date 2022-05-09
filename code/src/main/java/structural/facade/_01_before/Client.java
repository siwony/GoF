package structural.facade._01_before;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Client {

    public static void main(String[] args) {
        final String to = "siwony@google.com";
        final String from = "siwony.official@gmail.com";
        final String host = "127.0.0.1";

        final Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);

        final Session session = Session.getDefaultInstance(properties);

        try {
            final MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Test Mail from Java Program");
            message.setText("message");

            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
