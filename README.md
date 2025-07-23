# Notification System Assignment

This is a simple Java-based notification system that supports sending messages via:
-  Email
-  SMS
-  Push Notifications

The system uses Object-Oriented Programming principles like:
- Interfaces
- Generics
- Validation logic
- Retry mechanism (with simulated failure)
- CLI-based user input
- Lombok for Logging

## Features

- Validates message input (e.g., subject for email, phone number for SMS)
- Simulates random failures (70% success rate per message)
- Retries up to 3 times if a message fails
- Logs the result of each message (success or failure)
- CLI interface allows user to:
    - Choose notification type
    - Re-run or exit after each run

## Technologies

- Java 17+
- IntelliJ IDEA
- Java Collections
- Random failure simulation
- SLF4J (Lombok `@Slf4j` can be used for logging )

##  How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/notification-system.git

2. Open the project in IntelliJ IDEA.

3. Run the Main.java class to start the CLI-based notification menu