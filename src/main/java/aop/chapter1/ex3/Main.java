package aop.chapter1.ex3;

public class Main {
    public static void main(String[] args) {
        BankService bankService = new BankService();
        bankService.transferMoney("Ali", 1500);
    }
}
