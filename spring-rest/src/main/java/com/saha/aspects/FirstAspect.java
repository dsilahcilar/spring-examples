package com.saha.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class FirstAspect {

    @Before("execution(* com.saha..*Service.*(..))")
    public void first(JoinPoint jp) {
        log.info(jp.toString() + " basladi");
    }

    @AfterReturning(value = "execution(* com.saha..*Service.*(..))",
            returning = "returnValue")
    public void after(JoinPoint jp, Object returnValue) {
        log.info(returnValue.toString());
        log.info(jp.toString() + " bitti");
    }

}
