package structural.facade._02_after;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MimeMessageMaker {

    public MimeMessage makeMimeMessage(EmailSettings emailSettings, Session session) throws MessagingException {
        final MimeMessage mimeMessage = new MimeMessage(session);
        mimeMessage.setFrom(new InternetAddress(emailSettings.from));
        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailSettings.to));
        mimeMessage.setSubject(emailSettings.title);
        mimeMessage.setText(emailSettings.message);
        return mimeMessage;
    }
}
