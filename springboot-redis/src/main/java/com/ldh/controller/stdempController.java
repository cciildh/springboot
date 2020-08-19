package com.ldh.controller;

import java.math.BigDecimal;
import java.util.List;

import com.ldh.entity.StdEmp;
import com.ldh.service.StdEmpService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * stdempController
 */
@RestController
public class stdempController {

    //获取配置文件中自定义的属性值
    @Value("${hello.mesg}")
    private String msg;

    @Autowired
    private StdEmpService stdEmpServiceimpl;

    @RequestMapping("/getPropertiesValue")
    public String getPropertiesValue(){
        return this.msg;
    }

    @RequestMapping("/getListEmp")
    @ResponseBody
    public List<StdEmp> getListEmp() {
        return stdEmpServiceimpl.listEmp();
    }

    @RequestMapping("/findByName")
    @ResponseBody
    public List<StdEmp> findByName(String name) {
        List<StdEmp> list = stdEmpServiceimpl.findByName(name);
        return list;
    }

    @RequestMapping("/findByIdAndName")
    @ResponseBody
    public List<StdEmp> findByIdAndName(String name, Integer age) {
        List<StdEmp> list = stdEmpServiceimpl.findByNameAndAge(name, age);
        return list;
    }

    @RequestMapping("/queryByName")
    @ResponseBody
    public List<StdEmp> queryByName(String name) {
        List<StdEmp> emps = stdEmpServiceimpl.queryByName(name);
        return emps;
    }

    @RequestMapping("/updateById")
    @ResponseBody
    public void updateById(String name, BigDecimal id) {
        stdEmpServiceimpl.updateEmpNameById(name, id);
    }

    @RequestMapping("/queryAllOrderbyage")
    @ResponseBody
    public List<StdEmp> queryAllOrderbyage() {
        return stdEmpServiceimpl.queryAllOrderbyage();
    }

    @RequestMapping("/queryJonAll")
    @ResponseBody
    public List<Object> queryJonAll() {
        return stdEmpServiceimpl.queryJonAll();
    }

}