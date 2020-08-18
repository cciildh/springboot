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
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * serviceTest
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { app.class })
public class serviceTest {
    @Autowired
    private StdEmpRepository stdEmpRepository;

    @Test
    public void findAllTest() {
        List<StdEmp> list = stdEmpRepository.findAll();
        System.out.println(list.toString());
    }

    @Test
    @Transactional // @Transactional配合@Test默认是回滚
    @Rollback(false) // 取消回滚
    public void test() {
        StdEmp emp = new StdEmp();
        emp.setAddress("湖北广水");
        emp.setAge(19);
        emp.setId( BigDecimal.valueOf(10000) );
        emp.setName("李道华");
        emp.setPhone("0722-873367679");
        emp.setSexname("男");
        stdEmpRepository.save(emp);

    }

    @Test
    public void updateByid() {
        StdEmp emp = stdEmpRepository.findById(10000).get();
        emp.setPhone("0722-87332238");
        stdEmpRepository.save(emp);

        System.out.println(emp);

    } 

    @Test
    public void findByName() {
        List<StdEmp> list = stdEmpRepository.findByName("李道华1");
        System.out.println(list.toString());
    }

    @Test
    public void findByIdAndName() {
        List<StdEmp> list = stdEmpRepository.findByNameAndAge( "李道华",18);
        System.out.println(list.toString());
    }

}