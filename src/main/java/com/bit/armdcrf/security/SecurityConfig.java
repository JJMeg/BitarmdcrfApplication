package com.bit.armdcrf.security;

import com.bit.armdcrf.service.Security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Debbie Qiu
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    private CustomUserDetailsService customUserDetailsService;


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("demo").password("123456").roles("USER");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests().antMatchers("/getKaptcha").permitAll()
                .anyRequest().authenticated()
                .antMatchers("/index").hasAuthority("ADMIN")
                .and()
                .logout().permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/index")
                .failureUrl("/login?error")
                .permitAll()
                .and()
                .logout();
                //.logoutSuccessUrl("/index.html");
        http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity webSecurity) throws Exception{
        webSecurity.ignoring().antMatchers("/login.html","/login_timeout.html","/assets/**",
                "/B-JUI/**","/images/**","/json/**");
    }


    @Bean
    public LoginSuccessHandler loginSuccessHandler(){
        return new LoginSuccessHandler();
    }
}

