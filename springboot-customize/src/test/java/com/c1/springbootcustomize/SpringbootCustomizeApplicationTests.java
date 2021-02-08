package com.c1.springbootcustomize;

import com.c1.springbootcustomize.entity.Person;
import com.c1.springbootcustomize.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringbootCustomizeApplicationTests {

    @Test
    void contextLoads() throws CloneNotSupportedException {
        Person person = new Person();
        Map m = new HashMap();
        m.put("name","天龙八部");
        m.put("age","18");
        User user = new User();
        user.setCreateTime("1997");
        user.setId(1);
        user.setName("八稚女");
        person.setMap(m);
        person.setType("1");
        person.setUser(user);
        System.out.println(person);


        Person p2 = new Person();
        BeanUtils.copyProperties(person,p2);
        person.setType("2");
        person.getUser().setCreateTime("2021");
        person.getMap().put("hha","qita");
        System.out.println("person     "+person);
        System.out.println("p2   "+p2);
    }

}
