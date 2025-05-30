package designPatterns.decorator.ex2;

public class EmailNotifier implements Notifier {

    @Override
    public void send(String message) {
        System.out.println("here send email logic (Sending Email): " + message);
    }
}
