package com.example.controller;

import javax.validation.constraints.NotNull;

import com.example.entity.StdEmp;
import com.example.service.StdEmpservice;
import com.example.utils.ResponseMesg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * userController
 */
@RestController
@Validated //捕获方法参数校验异常必须添加
public class userController {

    @Autowired
    private StdEmpservice empserviceimpl;


    @RequestMapping("/add")
    @ResponseBody
    public ResponseMesg adduser(@Validated StdEmp  emp ) {

        int rows = empserviceimpl.Save(emp);
        if (rows > 0) {
            return ResponseMesg.ok();
        }
        return ResponseMesg.errorMsg("未知错误！");
    }
    @RequestMapping("/getemp")
    @ResponseBody
    public ResponseMesg geteMp(@NotNull(message="id不能为空")  Integer id){
        return ResponseMesg.ok();
    }
}