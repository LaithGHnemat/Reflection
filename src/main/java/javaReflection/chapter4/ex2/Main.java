package javaReflection.chapter4.ex2;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        MyService service = new RealService();

        MyService proxy = (MyService) Proxy.newProxyInstance(
                MyService.class.getClassLoader(),
                new Class[]{MyService.class},
                new TraceHandler(service)
        );

        proxy.run();
    }
}
