package notifications;

public class PushMessage {
    private String deviceToken;
    private String notificationText;

    public PushMessage(String deviceToken, String notificationText) {
        this.deviceToken = deviceToken;
        this.notificationText = notificationText;
    }

    public boolean isValid() {
        return deviceToken != null && !deviceToken.isBlank() && notificationText != null && !notificationText.isBlank();
    }

    @Override
    public String toString() {
        return "Push to: " + deviceToken + ", Text: " + notificationText;
    }
}
