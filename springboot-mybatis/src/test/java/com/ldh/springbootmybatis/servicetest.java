package com.ldh.springbootmybatis;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.ldh.app;
import com.ldh.entity.StdEmp;
import com.ldh.entity.StdUser;
import com.ldh.service.StdEmpSercice;
import com.ldh.service.StdUserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * servicetest 测试service中的方法 RunWith 启动器
 * SpringJUnit4ClassRunner：让junit与spring环境整合
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { app.class }) // 加载spingboot启动类

public class servicetest {

    // 注入调用方法所在的类
    @Autowired
    private StdEmpSercice serciceimpl;
    @Autowired
    private StdUserService userserviceimpl;

    @Test
    public void userTest() throws Exception {

     
        StdUser user = new StdUser();
        Date date = new Date();
        SimpleDateFormat dFormat = new SimpleDateFormat("MMddHHmmss");
        int id = Integer.valueOf(dFormat.format(date));
        user.setId(id);
        user.setUserId(id);
        user.setUserPassword("1234");
        user.setUserName("ldh");
        int rows = userserviceimpl.insert(user);

        System.out.println(rows);
    }

    @Test
    public void empTest() throws Exception  {
        StdEmp emp = new StdEmp();
        // emp.setId(id);
        emp.setAge(18);
        // emp.setName("ldh");
        emp.setSexname("男");
        emp.setAddress("湖北广水");
        emp.setPhone("0722-9527001");

        int rows = serciceimpl.insert(emp);

        System.out.println(rows);
    }
}