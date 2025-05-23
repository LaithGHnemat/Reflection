package javaReflection.chapter3.ex1;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) { // Constructor with parameters
        this.name = name;
        this.age = age;
    }

    public void sayHello() {
        System.out.println("Hi, my name is " + name + " and I am " + age + " years old.");
    }
}
