package com.saha.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class FirstAspect {

    // @Before("execution(* com.saha..*Service.*(..))")
    public void first(JoinPoint jp) {
        log.info(jp.toString() + " basladi");
    }

    //  @AfterReturning(value = "execution(* com.saha..*Service.*(..))",
    //        returning = "returnValue")
    public void after(JoinPoint jp, Object returnValue) {
        log.info(returnValue.toString());
        log.info(jp.toString() + " bitti");
    }

    // @AfterThrowing(value = "execution(* com.saha..*Service.*(..))",
    //       throwing = "ex")
    public void throwingAdvice(JoinPoint jp, Exception ex) {
        log.error("Bir hata olustu", ex.getCause().getMessage());
        log.error(jp.toString());
    }

    @Around("execution(* com.saha..*Service.*(..))")
    public Object aroundAdvice(ProceedingJoinPoint pjp)
            throws Throwable {
        log.info("Around calisacak");
        Object result = pjp.proceed();
        log.info("Around bitti");
        return result;
    }

}
