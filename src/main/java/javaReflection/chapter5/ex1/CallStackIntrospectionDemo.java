package javaReflection.chapter5.ex1;

import java.util.Arrays;

public class CallStackIntrospectionDemo {

    public static void main(String[] args) {
        CallStackIntrospectionDemo demo = new CallStackIntrospectionDemo();
        demo.methodA();
    }

    public void methodA() {
        methodB();
    }

    public void methodB() {
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        System.out.println("Call stack trace:");
        Arrays.stream(stack).forEach(System.out::println);
    }
}
