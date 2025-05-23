package javaReflection.chapter2.ex3;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class objSerializer {

    public static Field[] getAllFields(Object obj) {
        Class<?> cls = obj.getClass();
        List<Field> accum = new LinkedList<>();

        while (cls != null) {
            Field[] fields = cls.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                accum.add(fields[i]);
            }
            cls = cls.getSuperclass();
        }

        return accum.toArray(new Field[accum.size()]);
    }


    public static void main(String[] args) {
        MySubClass example = new MySubClass();
        Field[] allFields = getAllFields(example);
        Stream.of(allFields).forEach(f -> System.out.println("Field: " + f.getName()));

    }
}

class MySuperClass {
    private int superField;
}

class MySubClass extends MySuperClass {
    private String subField;
}

