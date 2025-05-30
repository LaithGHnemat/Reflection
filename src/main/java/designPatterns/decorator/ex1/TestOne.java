package designPatterns.decorator.ex1;

public class TestOne {

    public static void main(String[] args) {
        LabTop basicLab = new Ram(new SSD(new BasicLapTop() ));
        System.out.println("Description = " + basicLab.getDescription());
        System.out.println("Cost = " + basicLab.getCost());
    }
}
