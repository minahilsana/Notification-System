package notifications;

public class EmailMessage {
    private String to;
    private String subject;
    private String body;

    public EmailMessage(String to, String subject, String body) {
        this.to = to;
        this.subject = subject;
        this.body = body;
    }

    public boolean isValid() {
        return to != null && !to.isBlank() && subject != null && !subject.isBlank();
    }

    @Override
    public String toString() {
        return "Email to: " + to + ", Subject: " + subject + ", Body: " + body;
    }
}
