package javaReflection.chapter2.ex2;

import java.lang.reflect.Field;

public class ReflectionFieldExample {

    public static class Person {
        public String name = "Alice";
        private int age = 30;
        protected String address = "123 Street";
    }

    public static void main(String[] args) {
        try {
            Class<Person> personClass = Person.class;

            // 1. استخدام getField للحصول على الحقل العام "name"
            Field publicField = personClass.getField("name");
            System.out.println("Public Field: " + publicField.getName());

            // 2. محاولة الحصول على الحقل الخاص "age" باستخدام getField (سيفشل)
            try {
                Field privateField = personClass.getField("age");
            } catch (NoSuchFieldException e) {
                System.out.println("NoSuchFieldException for getField(\"age\") because 'age' is not public.");
            }

            // 3. الحصول على الحقل الخاص "age" باستخدام getDeclaredField (ينجح)
            Field declaredPrivateField = personClass.getDeclaredField("age");
            declaredPrivateField.setAccessible(true); // لجعل الحقل الخاص قابل للقراءة
            System.out.println("Declared Private Field: " + declaredPrivateField.getName() + " with value " + declaredPrivateField.get(new Person()));

            // 4. الحصول على جميع الحقول العامة (بما فيها الموروثة) باستخدام getFields
            System.out.println("\nAll public fields:");
            Field[] publicFields = personClass.getFields();
            for (Field f : publicFields) {
                System.out.println("  " + f.getName());
            }

            // 5. الحصول على كل الحقول المعلنة داخل الكلاس (بما فيها الخاص والمحمى) باستخدام getDeclaredFields
            System.out.println("\nAll declared fields:");
            Field[] declaredFields = personClass.getDeclaredFields();
            for (Field f : declaredFields) {
                System.out.println("  " + f.getName());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}