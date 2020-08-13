package com.ldh.springbootmybatis;

import com.ldh.app;
import com.ldh.entity.StdEmp;
import com.ldh.service.StdEmpSercice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * servicetest 测试service中的方法
 * RunWith  启动器
 * SpringJUnit4ClassRunner：让junit与spring环境整合
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {app.class})//加载spingboot启动类

public class servicetest {

    //注入调用方法所在的类
    @Autowired
   private StdEmpSercice serciceimpl;

    @Test
    public void userTest() throws Exception{

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