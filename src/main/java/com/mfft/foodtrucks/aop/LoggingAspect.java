package com.mfft.foodtrucks.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    // Pre-notification, logging before the target method is executed
    @Before("execution(* com.mfft.foodtrucks.service.*.*(..))")
    public void logBeforeServiceMethods(JoinPoint joinPoint) {
        logger.info("Calling method: {} with arguments: {}", joinPoint.getSignature().toShortString(), joinPoint.getArgs());
    }

    // Exception notification, logging when the target method throws an exception
    @AfterThrowing(pointcut = "execution(* com.mfft.foodtrucks.controller.*.*(..))", throwing = "ex")
    public void logAfterControllerException(JoinPoint joinPoint, Throwable ex) {
        logger.error("Exception in method: {} with message: {}", joinPoint.getSignature().toShortString(), ex.getMessage());
    }
}
