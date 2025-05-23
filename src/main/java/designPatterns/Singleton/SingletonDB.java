package designPatterns.Singleton;
/*
   we use singleton when we want to
   manage access to a resource
   which is shared by the entire application.
   and don't need to create the object more than one time
   */
public class SingletonDB {

    private String url = "http://localhost:8080/db-name";
    private String name = "anything";
    private static SingletonDB instance;

    private SingletonDB() {

    }

    public static SingletonDB getInstance() {
        if (instance == null) {
            instance = new SingletonDB();

        }
        return instance;
    }

    public void printDetails() {
        System.out.println(url);
        System.out.println(name);
        System.out.println("we uss object with Hash Code: "+ this.hashCode());
    }


}
