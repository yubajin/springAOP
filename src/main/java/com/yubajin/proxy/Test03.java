package com.yubajin.proxy;

import com.yubajin.proxy.proxyer.CglibProxy;
import com.yubajin.proxy.service.impl.UserServiceImpl;

public class Test03 {
    public static void main(String[] args) {
        // 获取目标对象
        UserServiceImpl target = new UserServiceImpl();
        // 获取代理对象
        UserServiceImpl proxy = new CglibProxy(target).createProxy();
        System.out.println(proxy.say("gp"));
    }
}
