package com.lix.mybatis.dao;

import com.lix.mybatis.domain.User;
import com.lix.mybatis.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * @author Admin
 */
@Component
public class UserDao2{
    @Autowired
    UserMapper userMapper;
    static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
    public void getUsers() {
        System.out.println(userMapper.getUsers());
    }

    public static void main(String[] args) throws IOException {

        UserDao2 bean = applicationContext.getBean(UserDao2.class);
        bean.getUsers();
    }
}
