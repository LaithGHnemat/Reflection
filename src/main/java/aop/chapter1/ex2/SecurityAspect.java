package aop.chapter1.ex2;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class SecurityAspect {

    @Before("execution(* aop.chapter1.ex2.OrderService.placeOrder(..)) && args(user)")
    public void checkPermission(String user) {
        if (!"admin".equals(user)) {
            throw new SecurityException("Not authorized: " + user);
        }
    }

}
