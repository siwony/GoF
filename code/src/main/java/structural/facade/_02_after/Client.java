package structural.facade._02_after;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Client {

    public static void main(String[] args) {
        final EmailSettings emailSettings = new EmailSettings(
                "siwony@google.com",
                "siwony.official@gmail.com",
                "127.0.0.1",
                "Test Mail from Java Program",
                "message"
        );

        final MailSender mailSender = new MailSender(emailSettings);
        mailSender.send();

    }
}
