package designPatterns.template;

public class Main {

    public static void main(String[] args) {
        VehicleTemplate car = new SalonCar();
        car.buildCar();
        System.out.println("------------------------------");
        VehicleTemplate truck = new Truck();
        truck.buildCar();

        VehicleTemplate nn= new VehicleTemplate() {
            @Override
            protected void installGearBox() {

            }

            @Override
            protected void assembleComponent() {

            }
        };
    }

}
