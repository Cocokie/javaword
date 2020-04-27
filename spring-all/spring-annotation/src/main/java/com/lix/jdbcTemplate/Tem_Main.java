package com.lix.jdbcTemplate;

import com.lix.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class Tem_Main {
    public static void main(String[] args) throws Exception {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://47.102.153.125:3306/lixin?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setPassword("lixin");
        dataSource.setUsername("lixin");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "select * from user";

        List<User> username1 = jdbcTemplate.query(sql, (rs, i) -> {
            String username = rs.getString("username");
            Integer age = rs.getInt("age");
            User user = new User();
            user.setAge(age);
            user.setUsername(username);
            return user;
        });
        System.out.println(username1);

    }
}
