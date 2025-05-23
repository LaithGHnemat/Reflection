package javaReflection.chapter2.ex6;

import java.lang.reflect.Array;

public class ReflectArrayExample {
    public static void main(String[] args) {
        int[] original = {1, 2, 3};

        int length = Array.getLength(original);
        for (int i = 0; i < length; i++) {
            Object value = Array.get(original, i);
            System.out.println("Value at " + i + ": " + value);
        }

        // Create a new array using reflection
        Object newArray = Array.newInstance(int.class, length);
        for (int i = 0; i < length; i++) {
            Array.set(newArray, i, Array.get(original, i));
        }

        System.out.println("Copy complete!");
    }
}
