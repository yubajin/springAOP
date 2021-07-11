package com.yubajin.aspectJ.service.impl;

import com.yubajin.aspectJ.annotation.Annotation02;
import com.yubajin.aspectJ.annotation.Annotation03;
import com.yubajin.aspectJ.entity.Student;
import com.yubajin.aspectJ.service.IUserService;
import org.springframework.stereotype.Service;

@Service
@Annotation03
public class UserServiceImpl implements IUserService {
    @Override
    public void fun1() {
        System.out.println("执行fun1....");
    }

    @Override
    public void fun2() {

    }

    @Override
    public String fun3(String userName) {
        System.out.println("fun3 ...");
        return "fun3";
    }

    @Override
    @Annotation02
    public String fun4(Student stu) {
        System.out.println("fun4 ..." + 1/0);
        return "HELLO";
    }


    public UserServiceImpl(){
        System.out.println("UserService 初始化了..");
    }
}
