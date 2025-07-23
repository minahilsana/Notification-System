package notifications;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class SMSNotifier implements Notifier<SMSMessage> {
    private final Random random = new Random();

    @Override
    public boolean send(SMSMessage message) {
        log.info("Sending SMS: {}", message);
        return random.nextDouble() > 0.3;
    }
}
