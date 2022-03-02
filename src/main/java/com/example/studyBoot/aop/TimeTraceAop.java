package com.example.studyBoot.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component //SpringConfig 빈에 추가해줘도된다
public class TimeTraceAop {

    @Around("execution(* com.example.studyBoot..*(..))")
    public Object execut(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        System.out.println("START: " +joinPoint.toString());
        try{
            return joinPoint.proceed();
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish-start;
            System.out.println(joinPoint.toString()+"timeMs = " + timeMs);
        }

    }
}
