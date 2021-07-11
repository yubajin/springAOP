package com.yubajin.proxy;

import com.yubajin.proxy.service.SomeService;
import com.yubajin.proxy.service.impl.SomeServiceImpl;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

public class Test02 {

    public static void main(String[] args) {
        // 获取目标对象
        final SomeService target = new SomeServiceImpl();
        // 获取代理对象
        SomeService proxy = (SomeService) Proxy.newProxyInstance(
                target.getClass().getClassLoader() // 类加载器
                , target.getClass().getInterfaces() // 目标对象实现的接口数组
                , new InvocationHandler() { // InvocationHandler的实现
                    /**
                     * 当代理对象执行相关方法的时候会执行的逻辑
                     * @return
                     * @throws Throwable
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("目标方法执行之前....");
                        // 调用目标对象的方法
                        String msg  = (String) method.invoke(target, args[0]);
                        System.out.println("目标方法执行之后....");
                        return msg.toUpperCase();
                    }
                }
        );
        System.out.println(proxy.doSome("aaa"));
    }
}
