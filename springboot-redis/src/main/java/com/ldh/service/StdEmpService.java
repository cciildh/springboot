package com.ldh.service;

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

    void updateEmpNameById(String name, Integer id);

    List<StdEmp> queryAllOrderbyage();
}