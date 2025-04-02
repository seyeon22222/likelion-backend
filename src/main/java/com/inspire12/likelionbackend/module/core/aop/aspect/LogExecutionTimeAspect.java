package com.inspire12.likelionbackend.module.core.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.inspire12.likelionbackend.module.core.aop.model.request.UserRequest;

@Order(2)
@Aspect
@Component
public class LogExecutionTimeAspect {
    private static final Logger log = LoggerFactory.getLogger("LogExecutionTimeAspect");

    @Pointcut("execution(* com.inspire12.likelionbackend.module.core.aop.service.UserService.registerUser(..))")
    public void logExecutionTimePointCut() {}

    // @Around("@annotation(com.inspire12.likelionbackend.module.core.aop.aspect.LogExecutionTime)")
    @Around("logExecutionTimePointCut()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        String username = (args.length > 0 && args[0] instanceof String) ?  (String) args[0]: "unknown";
        log.info("사용자 등록 시작 - username: {}", username);
        long startTime = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        log.info("사용자 등록 완료 - username: {} {}", username, endTime - startTime);
        return proceed;
    }


}
