package javaReflection.chapter1.ex3;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Vector;

public class IntrospectionExample {
    public static void main(String[] args) throws NoSuchMethodException {
        checkParamname();
        parameterTypes();

    }

    private static void parameterTypes() throws NoSuchMethodException {
        Method method = Vector.class.getMethod("addAll", new Class[] {Collection.class});
        Class<?>[] paramTypes = method.getParameterTypes();
        for (Class<?> paramType : paramTypes) {
            System.out.println("Param type : " + paramType.getTypeName() );
            System.out.println("isInterface: " + paramType.isInterface());
            System.out.println(Collection.class.isInterface());  // true
            System.out.println(String.class.isInterface());      // false

        }
    }

    private static void checkParamname() {
        Method[] methods = Vector.class.getMethods(); //
       /* Vector vector= new Vector();
        vector.removeElement() we wanna check this methode */
        for (Method method : methods) {
            if (method.getName().equals("removeElement")) {
                System.out.println("Method: " + method);
                Class<?>[] paramTypes = method.getParameterTypes();

                for (Class<?> paramType : paramTypes) {
                    System.out.println("  Param type: " + paramType.getName());

                    System.out.println("  Param type: " + paramType.getTypeName() );
                    System.out.println("    isArray: " + paramType.isArray());
                    System.out.println("    isInterface: " + paramType.isInterface());
                    System.out.println("    isPrimitive: " + paramType.isPrimitive());
                }
            }
           // System.out.println(method.getName());// all methode inside the victor will be printed
        }

    }
}
