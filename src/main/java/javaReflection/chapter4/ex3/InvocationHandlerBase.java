package javaReflection.chapter4.ex3;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public abstract class InvocationHandlerBase implements InvocationHandler {
    protected Object nextTarget;
    protected Object realTarget = null;

    protected InvocationHandlerBase(Object target) {
        nextTarget = target;
        if (nextTarget != null) {
            realTarget = findRealTarget(nextTarget);
            if (realTarget == null)
                throw new RuntimeException("findRealTarget failure");
        }
    }

    protected final Object getRealTarget() {
        return realTarget;
    }

    protected static final Object findRealTarget(Object t) {
        if (!Proxy.isProxyClass(t.getClass()))
            return t;

        InvocationHandler ih = Proxy.getInvocationHandler(t);
        if (ih instanceof InvocationHandlerBase) {
            return ((InvocationHandlerBase) ih).getRealTarget();
        } else {
            try {
                Field f = findField(ih.getClass(), "target");
                if (Object.class.isAssignableFrom(f.getType()) && !f.getType().isArray()) {
                    f.setAccessible(true);
                    Object innerTarget = f.get(ih);
                    return findRealTarget(innerTarget);
                }
                return null;
            } catch (Exception e) {
                return null;
            }
        }
    }

    // موك (Mock) لدالة findField، يمكنك استبدالها بـ mopex.Mopex.findField لاحقًا
    public static Field findField(Class<?> clazz, String name) throws NoSuchFieldException {
        Class<?> current = clazz;
        while (current != null) {
            try {
                return current.getDeclaredField(name);
            } catch (NoSuchFieldException e) {
                current = current.getSuperclass();
            }
        }
        throw new NoSuchFieldException("Field '" + name + "' not found in class hierarchy.");
    }
}
