package com.lix.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @program: basic-web
 * @description:
 * @author: lixin
 * @create: 2020-03-20 15:41
 **/
public class MyListener implements ServletContextListener {
    ServletContext servletContext;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        servletContext = sce.getServletContext();
        System.out.println("MyListener contextInitialized :" + servletContext.getInitParameter("name"));
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("MyListener contextDestroyed :" + (servletContext == sce.getServletContext()));
    }
}
