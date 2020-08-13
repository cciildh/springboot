package com.ldh.controller;

import java.util.List;

import javax.validation.constraints.Min;

import com.ldh.entity.StdEmp;
import com.ldh.entity.StdUser;
import com.ldh.service.StdEmpSercice;
import com.ldh.service.StdUserService;
import com.ldh.utils.JsonUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * stduserController
 * 
 */
@RestController
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
    public JsonUtils getEmp(@Min(value = 1, message = "id不能为空") Integer id) {
        return JsonUtils.ok(empSerciceimpl.selById(id));
    }

    @RequestMapping("/addemp")
    @ResponseBody
    // BindingResult result url参数验证结果bool
    // @Validated 开启对该对象的参数验证
    public JsonUtils addemp(@Validated StdEmp emp, BindingResult result) {
        System.out.println(result.hasErrors());
        if (result.hasErrors()) {
            return JsonUtils.errorValidate(result);
        }

        try {
            System.out.println(emp.toString());
            int rows = empSerciceimpl.insert(emp);
            if (rows > 0) {
                return JsonUtils.ok(emp);
            }
            return JsonUtils.errorMsg("新增人员失败");

        } catch (Exception e) {
            return JsonUtils.errorMsg(e.getMessage());
        }

    }

   
}