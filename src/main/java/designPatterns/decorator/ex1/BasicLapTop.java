package designPatterns.decorator.ex1;

public class BasicLapTop implements LabTop {

    @Override
    public double getCost() {
        return 300;
    }

    @Override
    public String getDescription() {
        return "HP";
    }
}
