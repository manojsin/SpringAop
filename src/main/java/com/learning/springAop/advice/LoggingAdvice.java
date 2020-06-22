package com.learning.springAop.advice;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAdvice {
    private Logger logger= LoggerFactory.getLogger(ExecutionTimeTrackerAdvice.class);
    private ObjectMapper objectMapper=new ObjectMapper();
    @Pointcut(value = "execution(* com.learning.springAop.*.*.*(..))")
    public void pointCut(){ }

     @Around("pointCut()")
    public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
        String methodName=pjp.getSignature().getName();
        String className=pjp.getTarget().getClass().toString();
        Object[] arg=pjp.getArgs();
        logger.info("Method Invoked "+className+" method name : "+methodName+" : with arguments : "+objectMapper.writeValueAsString(arg));
        Object proceed=pjp.proceed();
        logger.info(className+" method name : "+methodName+" : with Response : "+objectMapper.writeValueAsString(arg));
        return proceed;
    }
}
