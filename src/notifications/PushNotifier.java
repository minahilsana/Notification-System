package notifications;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class PushNotifier implements Notifier<PushMessage> {
    private final Random random = new Random();

    @Override
    public boolean send(PushMessage message) {
        log.info("Sending Push Notification: {}", message);
        return random.nextDouble() > 0.3;
    }
}
