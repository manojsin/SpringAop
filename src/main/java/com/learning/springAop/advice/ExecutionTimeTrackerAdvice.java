package com.learning.springAop.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeTrackerAdvice {

    private Logger logger= LoggerFactory.getLogger(ExecutionTimeTrackerAdvice.class);

   @Around("@annotation(com.learning.springAop.annotation.TrackExecutionTime)")
    public Object trackTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime=System.currentTimeMillis();
        Object proceed=proceedingJoinPoint.proceed();
        long endTime=System.currentTimeMillis();
        logger.info("MethodName : "+proceedingJoinPoint.getSignature()+"Total  execution time : "+(endTime-startTime)+" ms");
        return proceed;
    }
}
