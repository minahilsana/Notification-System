package notifications;

import java.util.Random;

public class EmailNotifier implements Notifier<EmailMessage> {
    private Random random = new Random();

    @Override
    public boolean send(EmailMessage message) {
        System.out.println("Sending Email: " + message);
        return random.nextDouble() > 0.3; // 70% success rate
    }
}
