package com.ldh.dao;

import java.util.List;

import com.ldh.entity.StdEmp;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * StdEmpRepository
 */
public interface StdEmpRepository extends JpaRepository<StdEmp,Integer> {

    List<StdEmp> findByName(String name);

    List<StdEmp> findByNameAndAge(String name,Integer age);
}