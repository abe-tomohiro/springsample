package com.example.springsample.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspectAround {
    @Around("execution(* *..*.*Controller.*(..))")
    public Object startLog(ProceedingJoinPoint jp) throws Throwable{

        System.out.println("メソッド開始Around：" + jp.getSignature());

        try{
            Object result = jp.proceed();
            System.out.println("メソッド終了Around：" + jp.getSignature());
            return result;
        } catch (Exception e) {
            System.out.println("メソッド異常終了Around：" + jp.getSignature());
            e.printStackTrace();
            throw e;
        }
    }
}
