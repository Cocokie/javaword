package com.lix;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class ApplicationMain {
    public static void main(String[] args) throws Exception {
             new Thread(){
                 @Override
                 public void run() {
                     System.out.println("sss");
                 }
             }.run();

//        System.out.println(1 % 5);
//        String sql = "select *from mybatis where name=?";
//        Properties p = new Properties();
//        InputStream resourceAsStream = ApplicationMain.class.getClassLoader().getResourceAsStream("mysql.properties");
//        p.load(resourceAsStream);
//        Class.forName(p.getProperty("jdbc.mysql.driver"));
//        Connection connection = DriverManager.getConnection(p.getProperty("jdbc.mysql.url"), p.getProperty("jdbc.mysql.username"), p.getProperty("jdbc.mysql.password"));
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setString(1,"头上佛");
//        ResultSet resultSet = preparedStatement.executeQuery();
//        while (resultSet.next()) {
//            System.out.println(resultSet.getString("name"));
//            System.out.println(resultSet.getString("username"));
//            System.out.println(resultSet.getString("password"));
//        }
    }
}
