package solid.liskovSubstitution;

public class InvalidBicycle extends Vehicle {
    @Override
    public void startEngine() {
        System.out.println("Bicycle does not have an engine to start.");
    }

    @Override
    public void drive() {
        System.out.println("Bicycle is pedaling.");
    }

    @Override
    public void stopEngine() {
        // dose not have an engine// solution not to extends from Vehicle
        System.out.println("Bicycle does not have an engine to stop.");
    }
}