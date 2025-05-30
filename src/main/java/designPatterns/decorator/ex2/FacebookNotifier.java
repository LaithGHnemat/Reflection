package designPatterns.decorator.ex2;

public class FacebookNotifier extends NotifierDecorator {
    public FacebookNotifier(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message); // يرسل أولاً كل الإشعارات السابقة
        System.out.println("Sending Facebook Message: " + message); // ثم يضيف إرسال Facebook
    }
}
