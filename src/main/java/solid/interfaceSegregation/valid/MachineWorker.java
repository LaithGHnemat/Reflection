package solid.interfaceSegregation.valid;

public class MachineWorker implements Workable, Repairable {
    @Override
    public void work() {
        System.out.println("Machine is working.");
    }

    @Override
    public void repairMachine() {
        System.out.println("Machine is repairing itself.");
    }
}