package javaReflection.chapter6.ex2;

import javaReflection.chapter6.ex1.SimpleClassLoader;

import java.lang.reflect.*;

public class SimpleSuiteTestProgram {

    static Class<?>[] formals = { String[].class };
    static Object[] actuals = { new String[]{ "" } };

    public static void main(String[] args) {
        try {
            for (int i = 0;; i++) {
                ClassLoader aClassLoader = new SimpleClassLoader("testcases");

                Class<?> c = aClassLoader.loadClass("TestCase" + i);
                Method m = null;

                try {
                    m = c.getMethod("main", formals);
                } catch (NoSuchMethodException e) {
                    System.out.println("TestCase" + i + ": no main in test case");
                    break;
                }

                try {
                    m.invoke(null, actuals);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("No more test cases found.");
        }
    }
}

