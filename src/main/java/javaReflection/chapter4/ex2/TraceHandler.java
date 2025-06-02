package javaReflection.chapter4.ex2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TraceHandler implements InvocationHandler {
    private final Object target;

    public TraceHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(">> Entering: " + method.getName());
        Object result = method.invoke(target, args);
        System.out.println("<< Exiting: " + method.getName());
        return result;
    }

}
