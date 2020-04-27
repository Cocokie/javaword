package com.lix.mapper;

import com.lix.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserMapper {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void getUser() {
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

    public void addAccount(String role,String money) {
        String sql = "update user set account = account+? where username= ?";
        jdbcTemplate.update(sql,money,role);
    }

    public void reduceAccount(String role,String money) {
        String sql = "update user set account = account-? where username= ?";
        jdbcTemplate.update(sql,money,role);
    }
}
