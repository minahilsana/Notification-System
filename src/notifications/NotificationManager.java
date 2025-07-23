package notifications;

import java.util.*;

public class NotificationManager<T> {
    private Notifier<T> notifier;
    private Map<T, Boolean> log = new HashMap<>();

    public NotificationManager(Notifier<T> notifier) {
        this.notifier = notifier;
    }

    public void sendAll(List<T> messages) {
        for (T message : messages) {
            boolean sent = false;

            try {
                System.out.println("\n>>> Validating message: " + message);
                var method = message.getClass().getMethod("isValid");
                boolean isValid = (boolean) method.invoke(message);

                if (!isValid) {
                    System.out.println("⚠️ Invalid message skipped: " + message);
                    log.put(message, false);
                    continue;
                }

                for (int i = 0; i < 3; i++) {
                    System.out.println("Attempt " + (i + 1) + ": Sending message...");
                    boolean success = notifier.send(message);
                    if (success) {
                        System.out.println("✅ Sent successfully.");
                        sent = true;
                        break;
                    } else {
                        System.out.println("❌ Failed");
                        System.out.println("Retrying... (" + (i + 1) + ")");
                    }

                }

                log.put(message, sent);
            } catch (Exception e) {
                System.out.println("Error validating message: " + e.getMessage());
                log.put(message, false);
            }
        }

        printLog();
    }

    private void printLog() {
        long success = log.values().stream().filter(v -> v).count();
        long failure = log.size() - success;

        System.out.println("\n==== Notification Summary ====");
        System.out.println("Total messages processed: " + log.size());
        System.out.println("✅ Success: " + success);
        System.out.println("❌ Failed : " + failure);
    }
    }
