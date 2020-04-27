package com.lix;


import com.lix.controller.UserController;
import com.lix.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application_Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserController bean = applicationContext.getBean(UserController.class);
        System.out.println(bean);
        bean.getUser();
    }
}
