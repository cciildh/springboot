package com.ldh.springbootdome.filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * filterApp
 */
@SpringBootApplication
@ServletComponentScan
public class filterApp {
    public static void main(String[] args) {
        SpringApplication.run(filterApp.class, args);
    }

    

}