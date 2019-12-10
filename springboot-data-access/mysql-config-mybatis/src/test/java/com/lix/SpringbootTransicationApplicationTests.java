package com.lix;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
class SpringbootTransicationApplicationTests {
    @Autowired
    private DataSource dataSource;
//    private ConfigTest configTest;

    @Test
    void contextLoads() {
        System.out.println("777");
        System.out.println(dataSource);
    }

}
