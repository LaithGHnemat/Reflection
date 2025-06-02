/*
package javaReflection.chapter4.ex4;


import jdk.internal.org.jline.reader.History;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DefaultReturnValueStrategy implements ReturnValueStrategy {
    @Override
    public Object getReturnValue(Proxy proxy, Method method, Object[] args, History history) {
        Class<?> returnType = method.getReturnType();

        if (returnType == void.class) {
            return null;  // لا قيمة إرجاع للطرق التي ترجع void
        }
        if (returnType == boolean.class) {
            return false;
        }
        if (returnType == int.class || returnType == long.class || returnType == short.class
                || returnType == byte.class || returnType == float.class || returnType == double.class) {
            return 0;  // الأعداد ترجع صفر
        }
        if (returnType == char.class) {
            return '\0';  // الحرف الافتراضي
        }
        // للقيم المرجعية (Objects) ترجع null (يمكن تعديلها لاحقًا)
        return null;
    }


    @Override
    public Object getReturnValueTow(Proxy p, Method m, Object[] args, History h) {
        Class<?> returnType = m.getReturnType();

        // إذا كانت القيمة المرجعة ليست نوعًا بدائيًا (primitive)
        if (!returnType.isPrimitive()) {
            try {
                // نحاول إنشاء نسخة جديدة من النوع المرجع (مثل كائن)
                return returnType.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                // إذا لم نتمكن من إنشاء الكائن، نرجع null
                return null;
            }
        }
        // الآن نتحقق من الأنواع البدائية
        else if (returnType == void.class) {
            return null;
        } else if (returnType == boolean.class) {
            return false;
        } else if (returnType == short.class) {
            return (short) 0;
        } else if (returnType == int.class) {
            return 0;
        } else if (returnType == long.class) {
            return 0L;
        } else if (returnType == double.class) {
            return 0.0;
        } else if (returnType == byte.class) {
            return (byte) 0;
        } else if (returnType == char.class) {
            return '\0';
        } else if (returnType == float.class) {
            return 0.0f;
        }

        throw new Error("Unknown return type: " + returnType);
    }
}
*/
