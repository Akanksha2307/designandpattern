public class TestDecorator {
    public static void main(String[] args) {
        Notifier notifier = new EmailNotifier();
        Notifier smsNotifier = new SMSNotifierDecorator(notifier);
        Notifier fullNotifier = new SlackNotifierDecorator(smsNotifier);
        fullNotifier.send("Server is down!");
    }
}
