package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * erroController
 */
@RestController
public class erroController {

    @RequestMapping("/show")
    public String show() {

        String str = null;
        str.length();

        return "";
    }
}