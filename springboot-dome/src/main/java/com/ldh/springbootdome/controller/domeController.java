package com.ldh.springbootdome.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * domeController
 */
@RestController
public class domeController {

    @RequestMapping("/show")
    public String show() {
        return "果双成到此一游";
    }
}