package com.ldh.controller;

import java.util.List;

import com.ldh.entity.StdEmp;
import com.ldh.service.StdEmpService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * stdempController
 */
@RestController
public class stdempController {

    @Autowired
    private StdEmpService stdEmpServiceimpl;

    @RequestMapping("/getListEmp")
    @ResponseBody
    public List<StdEmp> getListEmp() {
        return stdEmpServiceimpl.listEmp();
    }
}