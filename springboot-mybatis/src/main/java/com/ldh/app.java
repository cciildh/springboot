package com.ldh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * app
 */
@MapperScan("com.ldh.mapper")
@SpringBootApplication
public class app {

    public static void main(String[] args) {
        SpringApplication.run(app.class, args);
    }
}