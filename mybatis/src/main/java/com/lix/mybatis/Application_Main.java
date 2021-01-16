package com.lix.mybatis;

import com.lix.mybatis.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Application_Main {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User u = new User();
        u.setId(1);
        u.setAccount(2);
        //u.setUsername("lixin");
        //u.setAge(16);
        int update = sqlSession.update("basicUser.updateUserById", u);
        sqlSession.commit();
        System.out.println(update);
    }
}
