package designPatterns.decorator;

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
