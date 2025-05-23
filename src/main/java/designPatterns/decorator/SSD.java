package designPatterns.decorator;

public class SSD extends LapTopDecorator{

    public SSD(LabTop lapTop) {
        super(lapTop);
    }

    @Override
    public double getCost() {
        return super.getCost() + 37;
    }

    @Override
    public String getDescription() {
        return super.getDescription()+ ", SSD 124G";
    }

}
