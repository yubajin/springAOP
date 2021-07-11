package com.yubajin.aspectJ.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component// 将该对象加载到IoC容器中
@Aspect// 显示的表明当前类是一个切面类
public class MyAspectJ01 {

    @Pointcut("execution(* com.yubajin.aspectJ.service.impl.*.*(..))")  //execution定义目标对象的方法
    public void pointcut1(){

    }

    @Before("pointcut1()")  //切入点的复用
    public void aspectMethod01(){
        System.out.println("before aspectJ1....");
    }

    @Before("within(com.yubajin.aspectJ.service.impl.UserServiceImpl)")
    public void aspectMethod02(){
        System.out.println("before.....22");
    }

    /**
     * 在AOP中默认使用的是JDK代理模式 如果目标对象有实现接口
     * this 指的就是代理对象
     */
    @Before("this(com.yubajin.aspectJ.service.impl.UserServiceImpl)")
    public void aspectMethod03(){
        System.out.println("before.....33");
    }

    /**
     * target 目标对象是 com.yubajin.aspectJ.service.impl.UserServiceImpl
     */
    @Before("target(com.yubajin.aspectJ.service.impl.UserServiceImpl)")
    public void aspectMethod04(){
        System.out.println("before.....44");
    }
}
