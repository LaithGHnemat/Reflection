package javaReflection.chapter2.ex2;

import java.lang.reflect.Field;
import java.util.Arrays;

public class ReflectionFieldExample {

    public static class Person {
        public String name = "Alice";
        private int age = 30;
        protected String address = "123 Street";
    }

    public static void main(String[] args) {
        try {
            Class<Person> personClass = Person.class;
            Field publicField = personClass.getField("name");
            System.out.println("Public Field: " + publicField.getName());
            try {
                Field privateField = personClass.getField("age");
            } catch (NoSuchFieldException e) {
                System.out.println("NoSuchFieldException for getField(\"age\") because 'age' is not public.");
            }

            Field declaredPrivateField = personClass.getDeclaredField("age");
            declaredPrivateField.setAccessible(true);
            System.out.println("Declared Private Field: " + declaredPrivateField.getName() + " with value " + declaredPrivateField.get(new Person()));

            System.out.println("\nAll public fields:");
            Arrays.stream( personClass.getFields())
                    .map(Field::getName)
                    .forEach(name -> System.out.println("  " + name));


            System.out.println("\nAll declared fields:");

            Arrays.stream(personClass.getDeclaredFields())
                    .map(Field::getName)
                    .forEach(name -> System.out.println("  " + name));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}