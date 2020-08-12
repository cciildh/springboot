package com.ldh.service;

import com.ldh.entity.StdEmp;

/**
 * StdEmpSercice
 */
public interface StdEmpSercice {

    StdEmp selById(Integer id);

  
    int insert(StdEmp emp);

    int updateById(StdEmp emp);

    int deleteById(Integer userid);
}