package designPatterns.adapter;

public class Train implements Vehicle {


    @Override
    public void accelerate() {
        System.out.println("Car start to move");
    }

    @Override
    public void pushBreak() {
        System.out.println("Car stopped");

    }

    @Override
    public void soundHorn() {
        System.out.println("Beeb Beeb...");
    }
}
