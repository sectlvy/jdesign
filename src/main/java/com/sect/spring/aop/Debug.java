package com.sect.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Debug {

    public static void main(String[] args) {
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:com/lkl/spring/aop/aop-appcontext.xml");
        IBaseBusiness business = (BaseBusiness ) context.getBean("businessProxy");
        business.delete("猫");
    }

}