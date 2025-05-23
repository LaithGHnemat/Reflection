package solid.singleResponsibility;

public class EmployeeValid {

   /* note : This class is considered valid */
   /*  under the Single Responsibility Principle (SRP)*/
   /* because it has only one reason to change:*/
   /* If the structure of the employee's data changes.*/

    private String name;
    private int id;

    public EmployeeValid(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
