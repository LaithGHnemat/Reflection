package solid.liskovSubstitution;

public class ValidCar extends Vehicle {
    @Override
    public void startEngine() {
        System.out.println("Car engine started with key.");
    }

    @Override
    public void drive() {
        System.out.println("Car is driving.");
    }

    @Override
    public void stopEngine() {
        System.out.println("Car engine stopped.");
    }
}
