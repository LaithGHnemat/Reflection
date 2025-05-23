package javaReflection.chapter1.ex5;

interface A {}
interface B extends A {}

class Parent implements B {}
class Child extends Parent {}

public class ReflectionTest {
    public static void main(String[] args) {
        Class<?> cls = Child.class;

        System.out.println("Direct Superclass: " + cls.getSuperclass().getName());

        System.out.println("Interfaces implemented directly by Child:");
        for (Class<?> iface : cls.getInterfaces()) {
            System.out.println(" - " + iface.getName());
        }

        System.out.println("Interfaces implemented by Parent:");
        for (Class<?> iface : cls.getSuperclass().getInterfaces()) {
            System.out.println(" - " + iface.getName());
        }

        System.out.println("Superinterfaces of B:");
        for (Class<?> iface : B.class.getInterfaces()) {
            System.out.println(" - " + iface.getName());
        }
    }
}
