package javaReflection.chapter2.ex1;

import java.lang.reflect.Field;

class LeakyClass {
    private Object importantObject;
    private Object leakedObject;

    public LeakyClass(Object importantObject, Object leakedObject) {
        this.importantObject = importantObject;
        this.leakedObject = leakedObject;
    }
}

public class MemoryLeakInspector {

    public static void main(String[] args) throws Exception {
        Object dataToLeak = new String("I should be garbage collected!");
        LeakyClass leaky = new LeakyClass(new Object(), dataToLeak);

        Field[] fields = LeakyClass.class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(leaky);

            if (value == dataToLeak) {
                System.out.println("Memory leak detected in field: " + field.getName());
            }
        }
    }
}
