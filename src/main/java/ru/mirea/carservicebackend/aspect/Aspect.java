package ru.mirea.carservicebackend.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * The type Aspect.
 */
@Slf4j
@Component
@org.aspectj.lang.annotation.Aspect
public class Aspect {
    /**
     * All service methods.
     */
    @Pointcut("within(ru.mirea.carservicebackend.services.*)")
    public void allServiceMethods() {}


    /**
     * Log execution time object.
     *
     * @param joinPoint the join point
     * @return the object
     * @throws Throwable the throwable
     */
    @Around("allServiceMethods()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        log.info("{} takes {}ms", joinPoint.getSignature(), executionTime);
        return proceed;
    }
}