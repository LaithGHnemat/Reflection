package designPatterns.decorator;

public class Ram extends LapTopDecorator{
    public Ram(LabTop labTop) {
        super(labTop);
    }
    @Override
    public double getCost() {
        return super.getCost() + 40;
    }

    @Override
    public String getDescription() {
        return super.getDescription()+", Ram 8G";
    }
}
