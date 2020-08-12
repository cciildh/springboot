package com.ldh.springbootdome.sevlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * Secondapp Spring Boot 第二种方式注册servlet
 */
@SpringBootApplication
public class Secondapp {

    @Bean
    public ServletRegistrationBean  getServletRegistrationBean() {
        ServletRegistrationBean  bean = new ServletRegistrationBean<>(new secondSevlet(),"/second");
        return bean;

    }
    
    public static void main(String[] args) {
        SpringApplication.run(Secondapp.class, args);
    }

   

}