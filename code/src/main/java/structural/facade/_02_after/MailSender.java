package structural.facade._02_after;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailSender {

    final EmailSettings emailSettings;

    public MailSender(EmailSettings emailSettings) {
        this.emailSettings = emailSettings;
    }


    public void send(){
        final Properties properties = new MailPropertiesMaker().makeProperties(this.emailSettings.host);
        final Session session = Session.getDefaultInstance(properties);
        try {
            final MimeMessage mimeMessage = new MimeMessageMaker().makeMimeMessage(this.emailSettings, session);
            Transport.send(mimeMessage);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
