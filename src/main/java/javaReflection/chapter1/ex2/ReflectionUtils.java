package javaReflection.chapter1.ex2;
import java.awt.Color;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
public class ReflectionUtils {
    public static void setObjectColor(Object obj, Color color) {
        Class<?> cls = obj.getClass();
        try {
            Method method = cls.getMethod("setColor", Color.class);
            method.invoke(obj, color);
        } catch (NoSuchMethodException ex) {
            throw new IllegalArgumentException(
                    cls.getName() + " does not support method setColor(Color)"
            );
        } catch (IllegalAccessException ex) {
            throw new IllegalArgumentException(
                    "Insufficient access permissions to call setColor(Color) in class " + cls.getName()
            );
        } catch (InvocationTargetException ex) {
            throw new RuntimeException(ex);
        }
    }




}
