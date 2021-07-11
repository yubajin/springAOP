package com.yubajin.aspectJ;

import com.yubajin.aspectJ.entity.Student;
import com.yubajin.aspectJ.service.IUserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
//@EnableAspectJAutoProxy(proxyTargetClass = true)// 修改默认的代理模式为CGLIB代理模式
@EnableAspectJAutoProxy
public class JavaConfig {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(JavaConfig.class);
        IUserService bean = ac.getBean(IUserService.class);

        bean.fun1();
//        System.out.println(bean);

        System.out.println("------------------------------------------------------");

        bean.fun4(new Student());
//        UserServiceImpl bean1 = ac.getBean(UserServiceImpl.class); //没法去获取对象，因为返回的是一个代理对象
//        System.out.println(bean1);
//        bean1.fun1();

    }
}
