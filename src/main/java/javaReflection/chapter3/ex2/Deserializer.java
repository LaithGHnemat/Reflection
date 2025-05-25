package javaReflection.chapter3.ex2;

import org.jdom2.*;
import java.lang.reflect.*;
import java.util.*;
import java.lang.reflect.Array;
public class Deserializer {

    public static Object deserializeObject(Document source) throws Exception {
        List<Element> objList = source.getRootElement().getChildren();
        Map<String, Object> table = new HashMap<>();
        createInstances(table, objList);
        assignFieldValues(table, objList);
        return table.get("0");
    }

    private static void createInstances(Map<String, Object> table, List<Element> objList) throws Exception {
        for (Element oElt : objList) {
            Class<?> cls = Class.forName(oElt.getAttributeValue("class"));
            Object instance;

            if (!cls.isArray()) {
                Constructor<?> c = cls.getDeclaredConstructor();
                if (!Modifier.isPublic(c.getModifiers())) {
                    c.setAccessible(true);
                }
                instance = c.newInstance();
            } else {
                instance = Array.newInstance(
                        cls.getComponentType(),
                        Integer.parseInt(oElt.getAttributeValue("length"))
                );
            }

            table.put(oElt.getAttributeValue("id"), instance);
        }
    }

    private static void assignFieldValues(Map<String, Object> table, List<Element> objList) throws Exception {
        for (Element oElt : objList) {
            Object instance = table.get(oElt.getAttributeValue("id"));
            List<Element> fElts = oElt.getChildren();

            if (!instance.getClass().isArray()) {
                for (Element fElt : fElts) {
                    String fieldName = fElt.getAttributeValue("name");
                    String declaringClass = fElt.getAttributeValue("declaringclass");
                    Field field = Class.forName(declaringClass).getDeclaredField(fieldName);
                    if (!Modifier.isPublic(field.getModifiers())) {
                        field.setAccessible(true);
                    }

                    if (fElt.getAttribute("value") != null) {
                        String value = fElt.getAttributeValue("value");
                        Object convertedValue = convertValue(field.getType(), value);
                        field.set(instance, convertedValue);
                    } else {
                        // reference to another object
                        String ref = fElt.getAttributeValue("reference");
                        field.set(instance, table.get(ref));
                    }
                }
            } else {
                for (Element fElt : fElts) {
                    int index = Integer.parseInt(fElt.getAttributeValue("index"));
                    if (fElt.getAttribute("value") != null) {
                        String value = fElt.getAttributeValue("value");
                        Object convertedValue = convertValue(instance.getClass().getComponentType(), value);
                        Array.set(instance, index, convertedValue);
                    } else {
                        String ref = fElt.getAttributeValue("reference");
                        Array.set(instance, index, table.get(ref));
                    }
                }
            }
        }
    }

    private static Object convertValue(Class<?> type, String value) {
        if (type.equals(int.class) || type.equals(Integer.class)) return Integer.parseInt(value);
        if (type.equals(long.class) || type.equals(Long.class)) return Long.parseLong(value);
        if (type.equals(boolean.class) || type.equals(Boolean.class)) return Boolean.parseBoolean(value);
        if (type.equals(double.class) || type.equals(Double.class)) return Double.parseDouble(value);
        if (type.equals(float.class) || type.equals(Float.class)) return Float.parseFloat(value);
        if (type.equals(char.class) || type.equals(Character.class)) return value.charAt(0);
        if (type.equals(byte.class) || type.equals(Byte.class)) return Byte.parseByte(value);
        if (type.equals(short.class) || type.equals(Short.class)) return Short.parseShort(value);
        if (type.equals(String.class)) return value;
        throw new IllegalArgumentException("Unsupported field type: " + type);
    }
}
