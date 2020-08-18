package com.ldh.service;

import java.math.BigDecimal;
import java.util.List;

import com.ldh.entity.StdEmp;

/**
 * StdEmpService
 */
public interface StdEmpService {

    List<StdEmp> listEmp ();

    List<StdEmp> findByName(String name);

    List<StdEmp> findByNameAndAge(String name, Integer age);

    List<StdEmp> queryByName(String name);

    void updateEmpNameById(String name, BigDecimal id);

    List<StdEmp> queryAllOrderbyage();

    //关联查询
    List<Object> queryJonAll();
}