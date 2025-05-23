package designPatterns.decorator;

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
