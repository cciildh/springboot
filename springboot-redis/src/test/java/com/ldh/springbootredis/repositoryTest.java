package com.ldh.springbootredis;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import com.ldh.app;
import com.ldh.dao.StdEmpRepository;
import com.ldh.entity.StdEmp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * repositoryTest
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { app.class })
public class repositoryTest {
    @Autowired
    StdEmpRepository stdEmpRepository;

    @Test
    public void queryByName() {
        List<StdEmp> emps = stdEmpRepository.queryByName("李道华");
        System.out.println(emps.toString());
    }

    @Test
    @Transactional
    @Rollback(false)
    public void updateById() {
        stdEmpRepository.updateEmpNameById("李道华1", BigDecimal.valueOf(10000));
    }

    // 排序
    @Test
    public void QueryOrderbyage() {

        List<StdEmp> emps = stdEmpRepository.findAll(Sort.by(new Order(Direction.DESC, "age")));
        System.out.println(emps);
    }

}