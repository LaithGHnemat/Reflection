package javaReflection.chapter6.ex3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProductIH implements InvocationHandler {
    private Product target;
    private static final Class<?>[] interfaces = { Product.class };

    public static Product newInstance(AbstractProduct obj) {
        return (Product) Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                interfaces,
                new ProductIH(obj)
        );
    }

    private ProductIH(AbstractProduct obj) {
        this.target = obj;
    }

    public void setTarget(Product x) {
        this.target = x;
    }

    public Product getTarget() {
        return target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            return method.invoke(target, args);
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        }
    }


}
