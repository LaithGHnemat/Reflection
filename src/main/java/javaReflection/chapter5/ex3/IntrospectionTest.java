package javaReflection.chapter5.ex3;

public class IntrospectionTest {

    public static void main(String[] args) {
        printCurrentClassAndMethod();
    }

    public static void printCurrentClassAndMethod() {
        StackTraceElement element = new Throwable().getStackTrace()[0];
        System.out.println("Class: " + element.getClassName());
        System.out.println("Method: " + element.getMethodName());
        System.out.println("Line: " + element.getLineNumber());
        System.out.println("From file: " + element.getFileName());
    }




}
