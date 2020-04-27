package com.lix;


import com.lix.controller.UserController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application_Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-annotation.xml");

        UserController bean = applicationContext.getBean(UserController.class);
        bean.getUser();
    }
}
