package structural.facade._02_after;

public class EmailSettings {

    final String to;
    final String from;
    final String host;
    final String title;
    final String message;

    public EmailSettings(String to, String from, String host, String title, String message) {
        this.to = to;
        this.from = from;
        this.host = host;
        this.title = title;
        this.message = message;
    }
}
