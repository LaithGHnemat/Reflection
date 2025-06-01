package aop.chapter1.ex2;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class TransactionAspect {
    @Before("execution(* aop.chapter1.ex2.OrderService.placeOrder(..))")
    public void beginTransaction() {
        System.out.println("Transaction started");
    }

    @After("execution(* aop.chapter1.ex2.OrderService.placeOrder(..))")
    public void commitTransaction() {
        System.out.println("Transaction committed");
    }

}
