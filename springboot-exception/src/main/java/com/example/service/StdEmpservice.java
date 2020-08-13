package com.example.service;

import com.example.entity.StdEmp;

/**
 * empservice
 */
public interface StdEmpservice {

    int Save(StdEmp emp);

    StdEmp selById(int id);

    
}