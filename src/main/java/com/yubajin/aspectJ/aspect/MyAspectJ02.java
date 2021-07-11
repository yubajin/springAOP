package com.yubajin.aspectJ.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class MyAspectJ02 {

    /**
     * 前置通知
     */
    @Before("execution(* com.yubajin.aspectJ.service.impl.*.*(..))")
    public void before(){
        System.out.println("before aspectJ2...");
    }

    /**
     * @args 方法参数有被注解的
     */
    @Before("@args(com.yubajin.aspectJ.annotation.Annotation01)")
    public void before1(){
        System.out.println("before aspectJ2  @args...");
    }

    /**
     * @annotation 方法有被注解的
     */
    @Before("@annotation(com.yubajin.aspectJ.annotation.Annotation02)")
    public void before2(){
        System.out.println("before aspectJ2  @annotation...");
    }

    /**
     * @within 类有被注解的
     */
    @Before("@within(com.yubajin.aspectJ.annotation.Annotation03)")
    public void before3(){
        System.out.println("before aspectJ2  @within...");
    }

    /**
     * 后置通知  获取返回结果
     * @param res
     */
    @AfterReturning(value = "within(com.yubajin.aspectJ.service.impl.*)",returning = "res")
    public void afterReturning(Object res){
        System.out.println("后置通知..." + res);
    }

    /**
     * 环绕通知
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around(value = "within(com.yubajin.aspectJ.service.impl.*)")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("目标对象before....");
        Object[] args = proceedingJoinPoint.getArgs();

        Object res = proceedingJoinPoint.proceed(); // 目标对象方法执行
        System.out.println("目标对象after...." + res);
        return res;
    }

    /**
     * 异常通知
     * @param ex
     */
    @AfterThrowing(value = "within(com.yubajin.aspectJ.service.impl.*)",throwing = "ex")
    public void afterThrowing(Exception ex){
        System.out.println("异常通知产生了..." + ex);
    }

    /**
     * 最终通知
     */
    @After(value = "within(com.yubajin.aspectJ.service.impl.*)")
    public void after(){
        System.out.println("最终通知...");
    }
}
