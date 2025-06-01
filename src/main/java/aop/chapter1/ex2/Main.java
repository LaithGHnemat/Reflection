package aop.chapter1.ex2;

public class Main {

    public static void main(String[] args) {
        OrderService orderService = new OrderService();

        try {
            orderService.placeOrder("admin"); // ✅
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }

        try {
            orderService.placeOrder("user"); // ❌
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }
    }


}
