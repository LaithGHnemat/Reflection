package aop.chapter1.ex3;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {
    @Before("execution(* aop.chapter1.ex3.BankService.transferMoney(String, double)) && args(user, amount)")
    public void logBeforeTransfer(JoinPoint joinPoint, String user, double amount) {
        System.out.println("LOG: Preparing to transfer $" + amount + " for user: " + user);
    }

}
