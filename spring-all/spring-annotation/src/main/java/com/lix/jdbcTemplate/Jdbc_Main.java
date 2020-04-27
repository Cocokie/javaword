package com.lix.jdbcTemplate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbc_Main {
    public static void main(String[] args) throws Exception {
        String username = "lixin";
        String password = "lixin";
        String url = "jdbc:mysql://47.102.153.125:3306/lixin?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8";
        String mysqlClass = "com.mysql.cj.jdbc.Driver";
        Class.forName(mysqlClass);
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        String sql = "select * from user";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            String string = resultSet.getString(1);
            System.out.println(string);
            String string1 = resultSet.getString(2);
            System.out.println(string1);
            String string2 = resultSet.getString(3);
            System.out.println(string2);
        }
    }
}
