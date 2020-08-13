package com.example.controller;

import com.example.entity.StdEmp;
import com.example.service.StdEmpservice;
import com.example.utils.ResponseMesg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * userController
 */
@RestController
public class userController {

    @Autowired
    private StdEmpservice empserviceimpl;

    @RequestMapping("/{page}")
    public String Page(@PathVariable("page") String page) {
        return page;
    }

    @RequestMapping("/add")
    @ResponseBody
    public ResponseMesg adduser(StdEmp emp) {

        int rows = empserviceimpl.Save(emp);
        if (rows > 0) {
            return ResponseMesg.ok();
        }
        return ResponseMesg.errorMsg("未知错误！");
    }
}