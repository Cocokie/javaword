package com.lix.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        System.out.println("你是神魔恋");
//        resp.getWriter().println("qq");
//        ServletConfig servletConfig = getServletConfig();
//
//        System.out.println("============");
//        System.out.println(servletConfig.getInitParameter("name"));
//        System.out.println(servletConfig.getServletName());
//        ServletContext servletContext = servletConfig.getServletContext();
//        System.out.println(servletContext.getInitParameter("name"));
        System.out.println("servlet");
        //  System.out.println(servletContext.getAttribute("name"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
