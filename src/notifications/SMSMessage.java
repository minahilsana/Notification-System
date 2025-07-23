package notifications;

public class SMSMessage {
    private String phoneNumber;
    private String text;

    public SMSMessage(String phoneNumber, String text) {
        this.phoneNumber = phoneNumber;
        this.text = text;
    }

    public boolean isValid() {
        return phoneNumber != null && phoneNumber.matches("^\\d{10}$") && text != null && !text.isBlank();
    }

    @Override
    public String toString() {
        return "SMS to: " + phoneNumber + ", Text: " + text;
    }
}
