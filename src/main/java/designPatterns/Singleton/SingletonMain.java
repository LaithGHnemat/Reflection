package designPatterns.Singleton;

public class SingletonMain {

    public static void main(String[] args) {

        SingletonDB db= SingletonDB.getInstance();
        db.printDetails();


        SingletonDB db1= SingletonDB.getInstance();
        db1.printDetails();

        if(db==db1)
            System.out.println("the same obj");

        // both of those instances are
        // reference to the same location in the heap
        // they have the same hash code
    }
}
