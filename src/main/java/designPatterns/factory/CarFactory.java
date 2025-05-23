package designPatterns.factory;


import designPatterns.factory.model.Car;
import designPatterns.factory.model.Mercedes;
import designPatterns.factory.model.Tesla;

public class CarFactory {

    public static final int Mercedes = 1;
    public static final int Tesla = 2;

    public static Car createCar(int carType) {
        switch (carType) {
            case Mercedes:
                return new Mercedes();
            case Tesla:
                return new Tesla();
            default:
                return null;
        }
    }
}
