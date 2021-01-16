package com.lix.mybatis;

import com.lix.mybatis.domain.User;
import com.lix.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
import java.util.List;

public class Mapper_Main {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = mapper.getUsers();
        System.out.println(users);

        System.out.println("===================");
        //SqlSession sqlSession1 = sqlSessionFactory.openSession();
        UserMapper mapper1 = sqlSession.getMapper(UserMapper.class);
        User users1 = mapper1.getUserById("1");
        System.out.println(users1);
    }
}
