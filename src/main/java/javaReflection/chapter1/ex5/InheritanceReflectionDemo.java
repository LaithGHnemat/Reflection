package javaReflection.chapter1.ex5;

interface Living {}
class Animal implements Living {}
class Dog {}


public class InheritanceReflectionDemo {
    public static void main(String[] args) {
        Class<?> dogClass = Dog.class;

        // getSuperclass
        System.out.println("Superclass: " + dogClass.getSuperclass().getName());

        // getInterfaces
        for (Class<?> iface : dogClass.getInterfaces()) {
            System.out.println("Interface: " + iface.getName());
        }

        // isAssignableFrom
        System.out.println("Is Animal assignable from Dog? " + Animal.class.isAssignableFrom(Dog.class));

        // isInstance
        Dog dog = new Dog();
        System.out.println("Is dog an instance of Animal? " + Animal.class.isInstance(dog));
    }
}