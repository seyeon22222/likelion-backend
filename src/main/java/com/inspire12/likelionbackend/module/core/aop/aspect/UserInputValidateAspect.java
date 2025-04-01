package com.inspire12.likelionbackend.module.core.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserInputValidateAspect {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Around("@annotation(com.inspire12.likelionbackend.module.core.aop.aspect.UserInputValidate)")
    public Object userInputValidate(ProceedingJoinPoint joinPoint) throws Throwable {
        /* TODO username, email 두 input 값을 확인하는 코드를 넣어주세요 */
        return joinPoint.proceed();
    }
}
