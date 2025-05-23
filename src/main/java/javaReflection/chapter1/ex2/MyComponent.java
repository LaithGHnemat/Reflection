package javaReflection.chapter1.ex2;

import java.awt.*;

public class MyComponent {
    private Color color;


    public void setColor(Color color) {
        System.out.println("Color set to: " + color.toString());
        this.color=color;
    }

    public Color getColor() {
        return color;
    }
}
