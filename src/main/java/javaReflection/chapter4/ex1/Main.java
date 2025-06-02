package javaReflection.chapter4.ex1;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
       Service realService = new RealService();

        Service proxyService = (Service) Proxy.newProxyInstance(
                Service.class.getClassLoader(),
                new Class[]{Service.class},
                new LoggingHandler(realService)
        );

        proxyService.process();
    }



}
