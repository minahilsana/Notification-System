package notifications;

import java.util.Random;

public class SMSNotifier implements Notifier<SMSMessage> {
    private Random random = new Random();

    @Override
    public boolean send(SMSMessage message) {
        System.out.println("Sending SMS: " + message);
        return random.nextDouble() > 0.3;
    }
}
