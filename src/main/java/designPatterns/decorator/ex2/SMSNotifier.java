package designPatterns.decorator.ex2;

public class SMSNotifier extends NotifierDecorator {
    public SMSNotifier(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message); // يرسل الرسالة من الكائن الأساسي
        System.out.println("Sending SMS: " + message); // يضيف إرسال SMS
    }
}