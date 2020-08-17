package com.ldh.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.ldh.entity.StdEmp;
import com.ldh.entity.StdUser;
import com.ldh.service.StdEmpSercice;
import com.ldh.service.StdUserService;
import com.ldh.utils.ResponseMesg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * stduserController
 * 
 */
@RestController
@Validated // 方法参数异常处理
@RequestMapping("/user")
public class stduserController {

    @Autowired
    private StdUserService userServiceimpl;
    @Autowired
    private StdEmpSercice empSerciceimpl;

    @RequestMapping("/getUsers")
    @ResponseBody
    public List<StdUser> getUsers() {

        return userServiceimpl.selAll();
    }

    @RequestMapping("/getUser")
    @ResponseBody
    public StdUser getUser(Integer userid) {

        return userServiceimpl.selById(userid);
    }

    @RequestMapping("/getEmp")
    @ResponseBody
    public ResponseMesg getEmp(@NotNull(message="id不能为空") Integer id) {
        return ResponseMesg.ok(empSerciceimpl.selById(id));
    }

    @RequestMapping("/addemp")
    @ResponseBody
    // BindingResult result url参数验证结果bool
    // @Validated 开启对该对象的参数验证
    public ResponseMesg addemp(@Validated StdEmp emp) {
        int rows = empSerciceimpl.insert(emp);
        return ResponseMesg.ok(rows);

    }

}