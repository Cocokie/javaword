package com.lix.mybatis.dao;

import com.lix.mybatis.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

/**
 * @author Admin
 */
public class UserDao extends SqlSessionDaoSupport {

    public void getUsers() {
        SqlSession sqlSession = this.getSqlSession();
        List<User> objects = sqlSession.selectList("com.lix.mybatis.mapper.UserMapper.getUsers", new Object());
        System.out.println(objects);
    }

    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        UserDao bean = applicationContext.getBean(UserDao.class);
        bean.getUsers();
    }
}
