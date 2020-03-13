package com.lix.config;

import com.lix.interceptor.MyInterceptor;
import com.lix.interceptor.MyInterceptor2;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: javaworld
 * @description:
 * @author: lixin
 * @create: 2020-01-16 13:36
 **/
@Configuration
public class WebConfiguration implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getMyInterceptor()).addPathPatterns("/**");
        //registry.addInterceptor(getMyInterceptor2()).addPathPatterns("/**");
    }


//    public HandlerInterceptor getMyInterceptor2() {
//        return new MyInterceptor2();
//    }


    public HandlerInterceptor getMyInterceptor() {
        return new MyInterceptor();
    }
}
