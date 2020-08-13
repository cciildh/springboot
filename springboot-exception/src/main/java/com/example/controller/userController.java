package com.example.controller;

import javax.validation.constraints.Min;

import com.example.entity.StdEmp;
import com.example.service.StdEmpservice;
import com.example.utils.ResponseMesg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
    public ResponseMesg adduser(@Validated StdEmp  emp ,BindingResult bindingResult) {

        int rows = empserviceimpl.Save(emp);
        if (rows > 0) {
            return ResponseMesg.ok();
        }
        return ResponseMesg.errorMsg("未知错误！");
    }
    @RequestMapping("/getemp")
    @ResponseBody
    public ResponseMesg geteMp(@Min(value = 1,message = "id不能为空!") int id){
        return ResponseMesg.ok();
    }
}