package javaReflection.chapter1.ex6;

public class TestReflection {
    public static void main(String[] args) {
        // isAssignableFrom examples
        System.out.println(Object.class.isAssignableFrom(String.class));     // true
        System.out.println(java.util.List.class.isAssignableFrom(java.util.Vector.class)); // true
        System.out.println(double.class.isAssignableFrom(double.class));     // true
        System.out.println(Object.class.isAssignableFrom(double.class));     // false

        // isInstance examples
        String str = "Hello";
        System.out.println(String.class.isInstance(str));      // true
        System.out.println(Object.class.isInstance(str));      // true
        System.out.println(Number.class.isInstance(str));      // false

        java.util.List list = new java.util.Vector();
        System.out.println(java.util.List.class.isInstance(list)); // true
    }
}
