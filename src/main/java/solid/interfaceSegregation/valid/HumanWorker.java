package solid.interfaceSegregation.valid;

public class HumanWorker implements Workable, Eatable, Repairable {
    @Override
    public void work() {
        System.out.println("Human is working.");
    }

    @Override
    public void eat() {
        System.out.println("Human is eating.");
    }

    @Override
    public void repairMachine() {
        System.out.println("Human is repairing the machine.");
    }
}