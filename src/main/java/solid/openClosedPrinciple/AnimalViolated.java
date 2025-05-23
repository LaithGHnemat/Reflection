package solid.openClosedPrinciple;

public class AnimalViolated {

    private String type;

    public AnimalViolated(String type) {
        this.type = type;
    }

    public void makeSound() {
        if (type.equals("Dog")) {
            System.out.println("Woof!");
        } else if (type.equals("Cat")) {
            System.out.println("Meow!");
        } else if (type.equals("Bird")) {
            System.out.println("Tweet!");
        }
    }

    /* Every time you want to add a new animal (e.g., Lion),
    you must modify the makeSound() method.
    This means the class is not closed for modification.
    It becomes harder to maintain and more error-prone as you add more animals.*/
}
