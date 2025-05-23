package solid.interfaceSegregation.violted;

public class MachineWorkerViolated implements WorkerViolated {
    @Override
    public void work() {
        System.out.println("Machine is working.");
    }

    @Override
    public void eat() {
        // Doesn't make sense to implement this
        throw new UnsupportedOperationException("Machines don't eat.");
    }

    @Override
    public void repairMachine() {
        System.out.println("Machine is repairing itself.");
    }
}
