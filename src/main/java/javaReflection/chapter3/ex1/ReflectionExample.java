package javaReflection.chapter3.ex1;

import java.lang.reflect.Constructor;

public class ReflectionExample {

    public static void main(String[] args) {
        try {
            Class<?> cls = Class.forName("javaReflection.chapter3.ex1.Person");
            Constructor<?> constructor = cls.getConstructor(String.class, int.class);
            Object personObj = constructor.newInstance("Ahmed", 30);
            cls.getMethod("sayHello").invoke(personObj);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
