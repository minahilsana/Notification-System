package notifications;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class NotificationManager<T> {
    private final Notifier<T> notifier;
    private final Map<T, Boolean> logMap = new HashMap<>();

    public NotificationManager(Notifier<T> notifier) {
        this.notifier = notifier;
    }

    public void sendAll(List<T> messages) {
        for (T message : messages) {
            boolean sent = false;

            try {
                log.info("Validating message: {}", message);
                var method = message.getClass().getMethod("isValid");
                boolean isValid = (boolean) method.invoke(message);

                if (!isValid) {
                    log.warn("Invalid message skipped: {}", message);
                    logMap.put(message, false);
                    continue;
                }

                for (int i = 0; i < 3; i++) {
                    log.info("Attempt {}: Sending message...", i + 1);
                    if (notifier.send(message)) {
                        log.info("Message sent successfully on attempt {}", i + 1);
                        sent = true;
                        break;
                    } else {
                        log.warn("Send attempt {} failed.", i + 1);
                    }
                }

                logMap.put(message, sent);
            } catch (Exception e) {
                log.error("Error validating message: {}", e.getMessage());
                logMap.put(message, false);
            }
        }

        printLog();
    }

    private void printLog() {
        long success = logMap.values().stream().filter(v -> v).count();
        long failure = logMap.size() - success;

        log.info("\n--- Notification Summary ---");
        log.info("Total: {}", logMap.size());
        log.info("Success (sent): {}", success);
        log.info("Failure (failed): {}", failure);
    }
}
