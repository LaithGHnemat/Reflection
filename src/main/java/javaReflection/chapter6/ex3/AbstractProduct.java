package javaReflection.chapter6.ex3;
import javaReflection.chapter6.ex1.SimpleClassLoader;

import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;
public abstract class AbstractProduct implements Product {
    private static ClassLoader cl = null;
    private static String directory = null;
    private static Class<?> implClass;
    private static List<WeakReference<Product>> instances = new ArrayList<>();

    public static Product newInstance() throws Exception {
        AbstractProduct obj = (AbstractProduct) implClass.getDeclaredConstructor().newInstance();
        Product proxy = ProductIH.newInstance(obj);
        instances.add(new WeakReference<>(proxy));
        return proxy;
    }

    public static void reload(String dir) throws Exception {
        cl = new SimpleClassLoader(dir);
        implClass = cl.loadClass("ProductImpl");

        if (directory == null) {
            directory = dir;
            return;
        }


        Method evolve = implClass.getDeclaredMethod("evolve", Object.class);
        List<WeakReference<Product>> newInstances = new ArrayList<>();

        for (WeakReference<Product> ref : instances) {
            Product proxy = ref.get();
            if (proxy != null) {
                ProductIH ih = (ProductIH) Proxy.getInvocationHandler(proxy);
                Product oldObj = ih.getTarget();
                Product newObj = (Product) evolve.invoke(null, oldObj);
                ih.setTarget(newObj);
                newInstances.add(new WeakReference<>(proxy));
            }
        }

        instances = newInstances;
        directory = dir;
    }
}