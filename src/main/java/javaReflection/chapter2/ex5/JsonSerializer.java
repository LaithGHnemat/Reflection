package javaReflection.chapter2.ex5;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class JsonSerializer {
    public static String toJson(Object obj) {
        StringBuilder json = new StringBuilder();
        json.append("{\n");

        List<Field> fields = getAllFields(obj);
        List<String> jsonPairs = new ArrayList<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                String name = field.getName();
                Object value = field.get(obj);
                String type = field.getType().getSimpleName();

                // إذا كانت القيمة String، نحيطها بعلامات اقتباس
                String valueStr = (value instanceof String)
                        ? "\"" + value + "\""
                        : String.valueOf(value);

                // بناء تمثيل JSON لكل حقل
                String fieldJson = String.format(
                        "\"%s\": {\n  \"value\": %s,\n  \"type\": \"%s\"\n}",
                        name, valueStr, type
                );

                jsonPairs.add(fieldJson);

            } catch (IllegalAccessException e) {
                // نتجاهل الوصول غير المسموح
            }
        }

        json.append(String.join(",\n", jsonPairs));
        json.append("\n}");
        return json.toString();
    }

    private static List<Field> getAllFields(Object obj) {
        List<Field> fieldList = new ArrayList<>();
        Class<?> cls = obj.getClass();

        while (cls != null) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field f : declaredFields) {
                fieldList.add(f);
            }
            cls = cls.getSuperclass();
        }

        return fieldList;
    }

    public static void main(String[] args) {
        Person person = new Person("Ali", 30, "secret123");
        String json = toJson(person);
        System.out.println(json);
    }
}

// نفس الكلاسات السابقة
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
    }
}
