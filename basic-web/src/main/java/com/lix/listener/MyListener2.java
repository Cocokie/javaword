package com.lix.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener2 implements ServletContextListener {

    public MyListener2() {
    }

    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("MyListener2 contextInitialized :" + sce.getServletContext().getInitParameter("name"));

    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("MyListener2 contextDestroyed :" + sce.getServletContext().getInitParameter("name"));

    }
}
