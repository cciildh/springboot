package com.ldh.springbootmybatis;

import com.ldh.app;
import com.ldh.entity.StdEmp;
import com.ldh.service.StdEmpSercice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * servicetest 测试service中的方法
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = app.class)
@TestPropertySource(locations = "classpath:application.properties")
@ActiveProfiles("test")

public class servicetest {

    //注入调用方法所在的类
    @Autowired
   private StdEmpSercice serciceimpl;

    @Test
    public void userTest() {

        StdEmp emp = new StdEmp();
        // emp.setId(id);
        emp.setAge(18);
        emp.setName("ldh");
        emp.setSexname("男");
        emp.setAddress("湖北广水");
        emp.setPhone("0722-9527001");

        int rows = serciceimpl.insert(emp);

        System.out.println(rows);

    }
}