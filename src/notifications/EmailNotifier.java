package notifications;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class EmailNotifier implements Notifier<EmailMessage> {
    private final Random random = new Random();

    @Override
    public boolean send(EmailMessage message) {
        log.info("Sending Email: {}", message);
        return random.nextDouble() > 0.3; // 70% success rate
    }
}
