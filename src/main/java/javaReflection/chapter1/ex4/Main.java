package javaReflection.chapter1.ex4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {


        Device device = new Device();

        Method m1 = device.getClass().getMethod("isAvailable", null);
        boolean result = ((Boolean) m1.invoke(device, null)).booleanValue();


        Method m2 = device.getClass().getMethod("getTemperature", null);
        double temp = ((Double) m2.invoke(device, null)).doubleValue();

        // method.invoke just del with object so with primitive it ue wrapper class
        //see (Double)
        //(Boolean)



    }
}
