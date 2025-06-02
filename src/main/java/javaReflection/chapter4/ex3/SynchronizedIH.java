package javaReflection.chapter4.ex3;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SynchronizedIH extends InvocationHandlerBase{

    public static Object createProxy(Object obj) {
        return Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                new SynchronizedIH(obj));
    }

    private SynchronizedIH(Object obj) {
        super(obj);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        synchronized (getRealTarget()) {
            return method.invoke(nextTarget, args);
        }
    }
}
