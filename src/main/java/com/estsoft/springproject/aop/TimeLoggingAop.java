package com.estsoft.springproject.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeLoggingAop {
    // 특정 method() 를 호출했을 때, method의 수행 시간 측정
    @Around("execution(* com.estsoft.springproject.library..*(..))")
    // library 패키지 내의 특정 메서드를 실행했을 때 (books)

    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTimeMs = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());
        try {
            return joinPoint.proceed();
        } finally {
            long finishTimeMs = System.currentTimeMillis();
            long timeMs = finishTimeMs - startTimeMs;
            System.out.println("END: " + joinPoint.toString()+ " " + timeMs + "ms");
        }
    }

}