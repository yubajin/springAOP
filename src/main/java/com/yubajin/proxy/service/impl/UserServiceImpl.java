package com.yubajin.proxy.service.impl;

public class UserServiceImpl {

    public String say(String msg){
        System.out.println("Target running ..." + msg);
        return "nihao";
    }
}
