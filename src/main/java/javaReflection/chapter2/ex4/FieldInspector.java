package javaReflection.chapter2.ex4;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FieldInspector {

    public static void inspectFields(Object obj) {
        List<Field> fields = getAllFields(obj);
        System.out.println("=== Field Info ===");

        for (Field field : fields) {
            try {
                field.setAccessible(true);

                String fieldName = field.getName();
                String declaringClass = field.getDeclaringClass().getName();
                Class<?> fieldType = field.getType();
                Object value = field.get(obj); // قراءة قيمة الحقل

                System.out.printf("Field: %s%n", fieldName);
                System.out.printf("Declared in: %s%n", declaringClass);
                System.out.printf("Type: %s%n", fieldType.getSimpleName());
                System.out.printf("Value: %s%n", value);
                System.out.println("----------------------");

            } catch (IllegalAccessException e) {
                System.out.println("Cannot access field: " + field.getName());
            }
        }
    }

    private static List<Field> getAllFields(Object obj) {
        List<Field> fieldList = new ArrayList<>();
        Class<?> cls = obj.getClass();

        while (cls != null) {
            Field[] declaredFields = cls.getDeclaredFields();
            fieldList.addAll(Arrays.asList(declaredFields));
            cls = cls.getSuperclass();
        }

        return fieldList;
    }

    // مثال لتجربة الكود
    public static void main(String[] args) {
        Person p = new Person("Ali", 30, "secret123");
        inspectFields(p);
    }
}

// كلاس للاختبار
class Human {
    private String password;

    public Human(String password) {
        this.password = password;
    }
}

class Person extends Human {
    private String name;
    private int age;

    public Person(String name, int age, String password) {
        super(password);
        this.name = name;
        this.age = age;
    }}
