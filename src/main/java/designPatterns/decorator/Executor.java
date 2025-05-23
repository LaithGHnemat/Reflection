package designPatterns.decorator;

public class Executor {

    public static void main(String[] args) {
        LabTop basicLab = new Ram(new SSD(new BasicLapTop() ));
        System.out.println("Description = " + basicLab.getDescription());
        System.out.println("Cost = " + basicLab.getCost());
    }
}
