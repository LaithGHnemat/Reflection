package javaReflection.chapter1.ex6;

class Animal {}
class Dog extends Animal {}

public class TestAssign {
    public static void main(String[] args) {
        System.out.println(Animal.class.isAssignableFrom(Dog.class)); // true
        System.out.println(Dog.class.isAssignableFrom(Animal.class)); // false
    }
}
