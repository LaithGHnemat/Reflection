package aop.chapter1.ex1;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.createUser("Ahmad");
        userService.deleteUser("Ahmad");
    }
}
