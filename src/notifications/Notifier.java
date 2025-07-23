package notifications;

public interface Notifier<T> {
    boolean send(T message);
}
