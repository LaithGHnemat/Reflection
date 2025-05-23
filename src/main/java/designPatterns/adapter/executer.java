package designPatterns.adapter;

public class executer {

    public static void main(String[] args) {
        Vehicle train = new Train();
        Vehicle bike = new BicycleAdapter(new Bicycle());
        useVehicle(train);
        useVehicle(bike);
    }

    private static void useVehicle(Vehicle car) {
        car.accelerate();
        car.pushBreak();
        car.soundHorn();
        System.out.println();
    }
}
