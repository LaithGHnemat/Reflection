package aop.chapter1.ex1;

public class UserService {

    public void createUser(String name) {
        System.out.println("User created: " + name);
    }

    public void deleteUser(String name) {
        System.out.println("User deleted: " + name);
    }
}
