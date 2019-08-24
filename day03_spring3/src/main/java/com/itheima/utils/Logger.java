package com.itheima.utils;

import org.aspectj.lang.ProceedingJoinPoint;

public class Logger {

    public void beforeprintLog(){
        System.out.println("开始记录日志");
    }

    public void afterReturningprintLog(){
        System.out.println("开始记录日志");
    }

    public void afterThrowingprintLog(){
        System.out.println("开始记录日志");
    }

    public void afterprintLog(){
        System.out.println("开始记录日志");
    }


    //环绕通知
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object rtValue=null;
        try {
            Object[] args=pjp.getArgs();
            rtValue = pjp.proceed(args);
            return rtValue;
        } catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }finally {
            System.out.println("记录日志");
        }

    }
}
