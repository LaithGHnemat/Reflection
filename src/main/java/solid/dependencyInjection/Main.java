package solid.dependencyInjection;

public class Main {
    public static void main(String[] args) {
        Reader j= new JsonReader();
        Reader t= new TextReader();

        System.out.println(j.readFile());// in this case must read from json
        System.out.println(t.readFile());// in this case must read from text
    }
}
