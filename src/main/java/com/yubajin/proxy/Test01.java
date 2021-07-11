package com.yubajin.proxy;

import com.yubajin.proxy.proxyer.StaticSomeProxy;
import com.yubajin.proxy.service.SomeService;
import com.yubajin.proxy.service.impl.SomeServiceImpl;

public class Test01 {

    public static void main(String[] args) {
        // 获取目标对象
        SomeService target = new SomeServiceImpl();
        // 获取代理对象 增强目标对象
        SomeService proxy = new StaticSomeProxy(target);
        // 处理
        System.out.println(proxy.doSome("nihao"));
    }
}
