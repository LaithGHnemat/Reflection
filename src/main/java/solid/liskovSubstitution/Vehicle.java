package solid.liskovSubstitution;

public class Vehicle {
    public void startEngine() {
        System.out.println("Vehicle does not have an engine.");
    }

    public void drive() {
        System.out.println("The vehicle is moving.");
    }

    public void stopEngine() {
        System.out.println("Vehicle does not have an engine to stop.");
    }
}

