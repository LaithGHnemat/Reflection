package javaReflection.chapter1.ex1;

import java.util.List;

public class example1 {

    public static void main(String[] args) {
        example1 example1= new example1();
        example1.printName();

        test();
    }

    private static void test() {
        Class<?> arrayClass = int[].class;

        if (arrayClass.isArray()) {
            System.out.println("Component type: " + arrayClass.getComponentType().getName()); // int
        }

        System.out.println(List.class.isInterface()); // true
        System.out.println(String.class.isInterface());// no string is an obj


        System.out.println(int.class.isPrimitive());     // true
        System.out.println(Integer.class.isPrimitive()); // false
        System.out.println(void.class.isPrimitive());// true


    }

    public  void printName() {
        System.out.println(this.getClass().getName());
        System.out.println(this.getClass().getClassLoader());
        System.out.println(String.class.getName()); // java.lang.String
        System.out.println(int.class.getName());    // int
        System.out.println(String[].class.getName()); // [Ljava.lang.String;
    }
}
