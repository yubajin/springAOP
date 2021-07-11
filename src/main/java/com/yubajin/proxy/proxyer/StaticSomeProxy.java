package com.yubajin.proxy.proxyer;


import com.yubajin.proxy.service.SomeService;

public class StaticSomeProxy implements SomeService {


    private SomeService target; // 需要增强的目标对象

    public StaticSomeProxy(SomeService target) {
        this.target = target;
    }

    public String doSome(String msg) {
        System.out.println("目标对象执行之前的操作....");
        // 调用目标对象的方法
        String res = target.doSome(msg);
        System.out.println("目标对象执行之后的操作....");
        return res.toUpperCase();
    }
}
