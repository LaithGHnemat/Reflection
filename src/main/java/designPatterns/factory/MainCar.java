package designPatterns.factory;

import designPatterns.factory.model.Car;

        /* we  use for create an object
        without exposing the
        creation logic to the client
        */
public class MainCar {
    public static void main(String[] args) {
        Car car= CarFactory.createCar(CarFactory.Mercedes);
        car.makeCar();


        Car car2= CarFactory.createCar(CarFactory.Tesla);
        car2.makeCar();
    }
}
