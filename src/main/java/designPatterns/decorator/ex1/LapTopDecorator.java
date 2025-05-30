package designPatterns.decorator.ex1;

public class LapTopDecorator implements LabTop{

    private LabTop labTop;

    public LapTopDecorator(LabTop labTop) {
        this.labTop = labTop;
    }
    @Override
    public double getCost() {
        return this.labTop.getCost();
    }
    @Override
    public String getDescription() {
        return this.labTop.getDescription();
    }
}
