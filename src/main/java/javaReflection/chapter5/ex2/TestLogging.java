package javaReflection.chapter5.ex2;

public class TestLogging {

    private static SimpleLogger logger = new SimpleLogger();

    public static void methodA() {
        logger.logCurrent("Entered methodA");
        methodB();
        logger.logCurrent("Exiting methodA");
    }

    public static void methodB() {
        logger.logCurrent("Inside methodB");
    }

    public static void main(String[] args) {
        logger.logCurrent("Starting main");
        methodA();
        logger.logCurrent("Finished main");
    }
}
