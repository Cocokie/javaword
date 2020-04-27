package com.lix.dao;

import com.lix.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.List;

public class UserDao {
    SqlSessionFactory sqlSessionFactory;

    public UserDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public void getUsers() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> objects = sqlSession.selectList("user.getUsers",new Object());
        System.out.println(objects);
    }

    public static void main(String[] args) throws IOException {
        UserDao userDao = new UserDao(new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis.xml")));
        userDao.getUsers();
    }
}
