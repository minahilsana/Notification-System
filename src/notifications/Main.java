package notifications;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;

        System.out.println("==== Notification System ====");

        while (keepRunning) {
            int choice = -1;

            // Show menu until valid input (1-3)
            while (choice < 1 || choice > 3) {
                System.out.println("\nMenu:");
                System.out.println("1. Send Email");
                System.out.println("2. Send SMS");
                System.out.println("3. Send Push Notification");
                System.out.print("Choose an option (1-3): ");
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                } else {
                    System.out.println("❌ Invalid input. Please enter a number.");
                    scanner.nextLine(); // consume the invalid input
                }
            }

            switch (choice) {
                case 1:
                    Notifier<EmailMessage> emailNotifier = new EmailNotifier();
                    NotificationManager<EmailMessage> emailManager = new NotificationManager<>(emailNotifier);
                    List<EmailMessage> emails = List.of(
                            new EmailMessage("user1@example.com", "Welcome", "Hello!"),
                            new EmailMessage("user2@example.com", "", "This is a test email with No subject"),
                            new EmailMessage(" ", " ", "")
                    );
                    emailManager.sendAll(emails);
                    break;

                case 2:
                    Notifier<SMSMessage> smsNotifier = new SMSNotifier();
                    NotificationManager<SMSMessage> smsManager = new NotificationManager<>(smsNotifier);
                    List<SMSMessage> smsMessages = List.of(
                            new SMSMessage("1234567890", "Hi! Your order is ready."),
                            new SMSMessage("abc123", "Invalid number test")
                    );
                    smsManager.sendAll(smsMessages);
                    break;

                case 3:
                    Notifier<PushMessage> pushNotifier = new PushNotifier();
                    NotificationManager<PushMessage> pushManager = new NotificationManager<>(pushNotifier);
                    List<PushMessage> pushMessages = List.of(
                            new PushMessage("token123", "New notification!"),
                            new PushMessage("", "Missing token test")
                    );
                    pushManager.sendAll(pushMessages);
                    break;
            }

            // Ask if user wants to send again or exit
            System.out.print("\nDo you want to send another notification? (y/n): ");
            String again = scanner.nextLine().trim().toLowerCase();
            if (!again.equals("y")) {
                keepRunning = false;
                System.out.println("👋 Exiting Notification System. Goodbye!");
            } else {
                choice = -1; // reset for the next loop
            }
        }

        scanner.close();
    }
}
