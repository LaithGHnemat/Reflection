package designPatterns.decorator.ex2;

public class Test {

    public static void main(String[] args) {
        Notifier notifier = new FacebookNotifier(
                new SMSNotifier(
                        new EmailNotifier()));

        notifier.send("Hello User!");
    }
}
