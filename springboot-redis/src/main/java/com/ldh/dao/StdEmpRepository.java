package com.ldh.dao;

import java.math.BigDecimal;
import java.util.List;

import com.ldh.entity.StdEmp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * StdEmpRepository
 */
public interface StdEmpRepository extends JpaRepository<StdEmp, Integer>{

    //根据方法名自动生成查询sql（注意：方法名必须根据字段名及驼峰命名规则）
    List<StdEmp> findByName(String name);

    List<StdEmp> findByNameAndAge(String name, Integer age);

     // 查询测试
    // nativeQuery=true表示不需要转换成标准sql
    @Query(value = "select * from std_emp where name= ?", nativeQuery = true)
    List<StdEmp> queryByName(String name);

    // update
    @Query(value = "update std_emp set name = ? where id= ?", nativeQuery = true)
    @Modifying
    void updateEmpNameById(String name, BigDecimal id);


    //关联查询
    @Query(value="select a.id,name,age,sexName,address,b.payed_id,b.years,b.amount from std_emp a inner join EMP_PAYED b on a.id=b.id" , nativeQuery = true)
    List<Object> queryJonAll();
 
}