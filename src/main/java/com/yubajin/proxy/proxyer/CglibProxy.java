package com.yubajin.proxy.proxyer;


import com.yubajin.proxy.service.impl.UserServiceImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 动态代理Cglib代理
 */
public class CglibProxy implements MethodInterceptor {

    private UserServiceImpl target;

    public CglibProxy(UserServiceImpl target) {
        this.target = target;
    }

    /**
     * 给外界暴露的创建代理对象的方法
     * @return
     */
    public UserServiceImpl createProxy(){
        Enhancer enhancer = new Enhancer();
        // 指定父类
        enhancer.setSuperclass(UserServiceImpl.class);
        // 指定回调方法
        enhancer.setCallback(this);
        // 创建对象代理对象
        return (UserServiceImpl) enhancer.create();
    }

    /**
     * 需要执行具体的代理方法
     * @param o
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before...");
        String msg = (String) method.invoke(target, objects[0]);
        System.out.println("after...");
        return msg.toUpperCase();
    }
}
