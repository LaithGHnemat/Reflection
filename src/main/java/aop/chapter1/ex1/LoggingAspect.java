package aop.chapter1.ex1;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

    @Pointcut("execution(* aop.chapter1.ex1.UserService.*(..))")
    public void allPaymentMethods() {}

    @After("allPaymentMethods()")
    public void logAfterMethod() {
        System.out.println("Method in UserService executed.");
    }

}
