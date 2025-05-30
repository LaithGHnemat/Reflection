package designPatterns.decorator.ex2;

// كلاس مجرد (abstract) يقوم بلف كائن من نوع Notifier ليضيف عليه وظائف إضافية
public abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappee;

    // نمرر الكائن الذي نريد "تغليفه" أو توسيع سلوكه
    public NotifierDecorator(Notifier notifier) {
        this.wrappee = notifier;
    }

    @Override
    public void send(String message) {
        // يتم تفويض المهمة للكائن المغلف
        wrappee.send(message);
    }
}