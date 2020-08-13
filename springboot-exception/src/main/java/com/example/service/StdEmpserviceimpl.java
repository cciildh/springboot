package com.example.service;

import com.example.entity.StdEmp;

import org.springframework.stereotype.Service;

/**
 * StdEmpserviceimpl
 */
@Service
public class StdEmpserviceimpl implements StdEmpservice {

    @Override
    public int Save(StdEmp emp) {
        return 1;
    }

    @Override
    public StdEmp selById(int id) {
        return null;
    }

    
}