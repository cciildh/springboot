package com.ldh.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import com.ldh.dao.StdEmpRepository;
import com.ldh.entity.StdEmp;
import com.ldh.service.StdEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

/**
 * StdEmpServiceimpl
 */
@Service
public class StdEmpServiceimpl implements StdEmpService {

    @Autowired
    StdEmpRepository stdEmpRepository;

    @Override
    public List<StdEmp> listEmp() {
        return stdEmpRepository.findAll();
    }

    @Override
    public List<StdEmp> findByName(String name) {
        return stdEmpRepository.findByName(name);
    }

    @Override
    public List<StdEmp> findByNameAndAge(String name, Integer age) {
        return stdEmpRepository.findByNameAndAge(name, age);
    }

    @Override
    public List<StdEmp> queryByName(String name) {
        return stdEmpRepository.queryByName(name);
    }

    @Override
    @Transactional
    public void updateEmpNameById(String name, Integer id) {
        stdEmpRepository.updateEmpNameById(name, id);
    }

    /**
     * 排序
     */
    @Override
    public List<StdEmp> queryAllOrderbyage() {
        return stdEmpRepository.findAll(Sort.by(new Order(Direction.DESC, "age")));
    }

    
}