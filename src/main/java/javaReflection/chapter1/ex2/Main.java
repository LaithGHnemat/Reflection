package javaReflection.chapter1.ex2;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        MyComponent comp = new MyComponent();
        ReflectionUtils.setObjectColor(comp, Color.BLUE);

        System.out.println("Must be 255 : "+comp.getColor().getBlue());
        System.out.println("Must be 0   : "+comp.getColor().getGreen());
    }
}
