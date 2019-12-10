package com.lix.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource(value = "classpath:dbmysql/mysql.properties")
public class ApplicationConfig {


    @Bean
    @ConfigurationProperties(prefix = "mysql")
    public DataSource dataSource(){
        return new DruidDataSource();
    }
}
