package com.alper.couponear.logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class CouponearLogger {
    private static  final String COTROLLERS_POINT_CUT = "within(com.alper.couponear.campaing.CampaignController)";

    @Around(COTROLLERS_POINT_CUT)
    public Object logExec(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Signature signature = proceedingJoinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        System.out.println("BEFORE- {} - " + method.getName());
        var proceed =  proceedingJoinPoint.proceed();
        System.out.println("AFTER - {} - " + proceed.toString());
        return proceed;
    }
}
