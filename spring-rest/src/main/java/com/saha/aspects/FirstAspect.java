package com.saha.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
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

    @After("execution(* com.saha..*Service.*(..))")
    public void after(JoinPoint jp) {
        log.info(jp.toString() + " bitti");
    }

}
