package com.ldh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * app
 */
@MapperScan("com.ldh.mapper")
@SpringBootApplication
@EnableTransactionManagement //开启事务管理
public class app {

    public static void main(String[] args) {
        SpringApplication.run(app.class, args);
    }
}