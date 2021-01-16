package com.security.demo.config;

import com.security.demo.filter.MyFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 配置校验规则，可以配置内存的用户（用户名密码，带有什么权限）。
     *              也可以基于数据库认证，通过重写UserDetailsService的loadUserByUserName方法查询数据库中的用户
     *              也可以设置密码加密方式
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().
                withUser("admin").password("{noop}123").roles("admin","user")
                .and().withUser("lixin").password("{noop}123").roles("user");
    }
    /**
     * 配置Security的filter链,webSecurity在创建初始过滤器的时候就生成了，
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {

        super.configure(web);
    }
    /**
     * 对每个请求进行详细的安全性控制在于重载configure(HttpSecurity)方法，它为不同的url路径都有选择地应用安全性
     * 配置路径规则，以及路径规则对应的角色,可以在filters添加默认过滤器
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/admin").hasRole("admin")
                .antMatchers("/get").hasRole("user").anyRequest().authenticated().and().formLogin()
                .and().httpBasic().and().addFilter(new MyFilter());
    }


//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
}
