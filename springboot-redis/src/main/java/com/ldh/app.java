package com.ldh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * app
 */
@SpringBootApplication
@EnableTransactionManagement
public class app {

    public static void main(String[] args) {
        SpringApplication.run(app.class, args);
    }
}