package com.qbk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @Author: quboka
 * @Date: 2018/11/28 18:37
 * @Description: Security配置
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter { //Security 配置适配器


    @Autowired
    private AuthenticationSuccessHandler myAuthenticationSuccessHandler ;
    @Autowired
    private AuthenticationFailureHandler myAuthenticationFailureHandler;

    //密码加密解密
    @Bean
    public PasswordEncoder passwordEncoder() {
        //也可以返回自己的实现类，自己写加密逻辑
        return new BCryptPasswordEncoder();
    }


    //HttpSecurity 配置
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin()//表单登陆方式
                .loginPage("/login.html")//自定义登录页
                .loginProcessingUrl("/test/login")//登陆接口
                .successHandler(myAuthenticationSuccessHandler)
                .failureHandler(myAuthenticationFailureHandler)
//        http.httpBasic() // httpBasic登陆方式
                .and()
                .authorizeRequests()//授权请求
                .antMatchers("/login.html").permitAll()//匹配不需要身份认证
                .anyRequest()//任何请求
                .authenticated()//身份认证
                .and().csrf().disable()//跨站请求伪造防护不启用
                ;
    }
}




















