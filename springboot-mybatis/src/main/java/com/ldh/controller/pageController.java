package com.ldh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * pageController
 */
@Controller
public class pageController {

    @RequestMapping("/{page}")
    public String showPage(@PathVariable("page") String page)
    {
        return page;
    }
    
}