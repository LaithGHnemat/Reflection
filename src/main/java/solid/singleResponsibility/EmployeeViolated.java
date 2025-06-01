package solid.singleResponsibility;

public class EmployeeViolated {

    private String name;
    private int id;

    public EmployeeViolated(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void print() {
        System.out.println("Employee: " + name + ", ID: " + id);
    }
     // note : this is Violated SRP cause its do more than one thing
}
