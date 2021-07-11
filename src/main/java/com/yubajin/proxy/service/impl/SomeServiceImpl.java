package com.yubajin.proxy.service.impl;

import com.yubajin.proxy.service.SomeService;

public class SomeServiceImpl implements SomeService {
    public String doSome(String msg) {
        System.out.println("目标对象方法执行了...." + msg);
        return "hello";
    }
}
