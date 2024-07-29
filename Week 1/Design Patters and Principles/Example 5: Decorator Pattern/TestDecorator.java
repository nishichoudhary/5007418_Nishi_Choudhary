package DecoratorPatternExample;

public class TestDecorator {
    public static void main(String[] args)
    {
        Notifier emailNotifier = new EmailNotifier();

        Notifier smsAndEmailNotifier = new SMSNotifierDecorator(emailNotifier);

        Notifier allNotifier = new SlackNotifierDecorator(smsAndEmailNotifier);

        allNotifier.send("This is a test message");
    }
}