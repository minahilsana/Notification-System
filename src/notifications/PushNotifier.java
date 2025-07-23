package notifications;

import java.util.Random;

public class PushNotifier implements Notifier<PushMessage> {
    private Random random = new Random();

    @Override
    public boolean send(PushMessage message) {
        System.out.println("Sending Push Notification: " + message);
        return random.nextDouble() > 0.3;
    }
}
