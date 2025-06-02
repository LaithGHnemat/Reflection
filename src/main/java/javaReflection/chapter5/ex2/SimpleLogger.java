package javaReflection.chapter5.ex2;

public class SimpleLogger implements Logger {

    @Override
    public void log(String className, String methodName, int lineNumber, String message) {
        System.out.printf("[%s:%d] %s - %s%n", className, lineNumber, methodName, message);
    }

    public void logCurrent(String message) {
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        // stack[0] = getStackTrace, stack[1] = logCurrent, stack[2] = caller
        StackTraceElement caller = stack[2];
        log(caller.getClassName(), caller.getMethodName(), caller.getLineNumber(), message);
    }
}
