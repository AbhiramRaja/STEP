public class NotificationService {
    public void triggerAlert() {
        Notifier n = new Notifier() {
            @Override
            public void send(String message) {
                System.out.println("ALERT: " + message);
            }
        };
        n.send("Server CPU usage high");
    }

    public static void main(String[] args) {
        new NotificationService().triggerAlert();
    }
}