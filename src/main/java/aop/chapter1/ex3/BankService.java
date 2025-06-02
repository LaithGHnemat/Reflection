package aop.chapter1.ex3;

public class BankService {
    public void transferMoney(String user, double amount) {
        System.out.println("Transferring $" + amount + " for user: " + user);
    }

}
