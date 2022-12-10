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
    private static  final String POINT_CUT = "within(com.alper.couponear..*)";

    @Around(POINT_CUT)
    public Object logExec(ProceedingJoinPoint proceedingJoinPoint) {
        Object proceed = null;

        try {
            Signature signature = proceedingJoinPoint.getSignature();
            MethodSignature methodSignature = (MethodSignature) signature;
            Method method = methodSignature.getMethod();
            proceed =  proceedingJoinPoint.proceed();
            System.out.println("[ METHOD_EXECUTED ]-- " + method  + "  -- [ METHOD_RESULT ]-- " + proceed.toString());
        }catch (Exception e){
            System.out.println("[ LOG_ERROR ]-- Method Logging Error when execution process" + e);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

        return proceed;
    }
}
