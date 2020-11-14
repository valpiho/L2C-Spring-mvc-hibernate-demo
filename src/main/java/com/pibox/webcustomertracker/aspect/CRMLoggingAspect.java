package com.pibox.webcustomertracker.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.pibox.webcustomertracker.controller.*.*(..))")
    private void forControllerPackage() {}

    @Pointcut("execution(* com.pibox.webcustomertracker.service.*.*(..))")
    private void forServicePackage() {}

    @Pointcut("execution(* com.pibox.webcustomertracker.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow(){}

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint){
        String theMethod = joinPoint.getSignature().toShortString();
        logger.info("=====>>> in @Before: calling method: " + theMethod);

        Object[] args = joinPoint.getArgs();
        for (Object arg: args) {
            logger.info("=====>>> argument: " + arg);
        }
    }

    @AfterReturning(pointcut = "forAppFlow()",
            returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        String theMethod = joinPoint.getSignature().toShortString();
        logger.info("=====>>> in @AfterReturning: from method: " + theMethod);

        logger.info("=====>>> result: " + result);
    }
}
