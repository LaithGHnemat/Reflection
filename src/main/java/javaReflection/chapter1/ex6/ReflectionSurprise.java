package javaReflection.chapter1.ex6;

public class ReflectionSurprise {
    public static void main(String[] args) {
        method1();
        methode2();
    }

    private static void methode2() {
        // true: Object.class هو instance من Class
        System.out.println(Class.class.isInstance(Object.class));

        // true: Class هو subclass من Object
        System.out.println(Object.class.isAssignableFrom(Class.class));

        // true: Class هو instance من نفسه!
        System.out.println(Class.class.isInstance(Class.class));

        // Demonstrating toString from Object works on metaobjects
        System.out.println(Class.class.toString());  // class java.lang.Class
    }

    private static void method1() {
        Class<?> c = Class.class;
        System.out.println(c.isInstance(c)); // true
        System.out.println("Type of Class.class: " + c.getName());  // java.lang.Class
    }
}
