package com.ldh.service.impl;

import java.util.List;

import com.ldh.dao.StdEmpRepository;
import com.ldh.entity.StdEmp;
import com.ldh.service.StdEmpService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * StdEmpServiceimpl
 */
@Service
public class StdEmpServiceimpl implements StdEmpService {

    @Autowired
    private StdEmpRepository stdEmpRepository;

    @Override
    public List<StdEmp> listEmp() {
        return stdEmpRepository.findAll();
    }

    
}