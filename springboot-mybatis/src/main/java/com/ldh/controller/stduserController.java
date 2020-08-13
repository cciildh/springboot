package com.ldh.controller;

import java.util.List;

import com.ldh.entity.StdEmp;
import com.ldh.entity.StdUser;
import com.ldh.service.StdEmpSercice;
import com.ldh.service.StdUserService;
import com.ldh.utils.JsonUtils;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<StdUser> getUsers() {

        return userServiceimpl.selAll();
    }

    @RequestMapping("/getUser")
    public StdUser getUser(Integer userid) {

        return userServiceimpl.selById(userid);
    }

    @RequestMapping("/getEmp")
    public StdEmp getEmp(Integer id) {
        return empSerciceimpl.selById(id);
    }

    @RequestMapping("/addemp")
    @ResponseBody
    public JsonUtils addemp(StdEmp emp) {
        try {
            System.out.println(emp.toString());
            int rows = empSerciceimpl.insert(emp);
            if (rows > 0) {
                return JsonUtils.ok();
            } else {
                return JsonUtils.errorMsg("新增人员失败");
            }
        } catch (Exception e) {
            return JsonUtils.errorMsg(e.getMessage());
        }
       

    }
}