package com.ldh.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.ldh.entity.StdEmp;
import com.ldh.entity.StdUser;
import com.ldh.mapper.StdEmpMapper;
import com.ldh.mapper.StdUserMapper;
import com.ldh.service.StdEmpSercice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * StdEmpSerciceimpl
 */
@Service
public class StdEmpSerciceimpl implements StdEmpSercice {

    @Autowired
    private StdEmpMapper empmapperimpl;
    @Autowired
    private StdUserMapper usermapperimpl;

    @Override
    public StdEmp selById(Integer id) {
        return empmapperimpl.selectByPrimaryKey(id);
    }

    @Transactional(rollbackFor=Exception.class) // 表示该方法将被springboot事务管理器所管理,出现异常回滚
    @Override
    public int insert(StdEmp emp) {
        Date date = new Date();
        SimpleDateFormat dFormat = new SimpleDateFormat("MMddHHmmss");
        int id = Integer.valueOf(dFormat.format(date));
        emp.setId(id);
        empmapperimpl.insert(emp);


        StdUser user = new StdUser();
        user.setId(emp.getId());
        user.setUserId(id);
        user.setUserName(emp.getName());
        user.setUserPassword("123456");
        user.setUserDate(date);
        int rows = usermapperimpl.insert(user);

        return rows;
    }

    @Override
    public int updateById(StdEmp emp) {
        return 0;
    }

    @Override
    public int deleteById(Integer userid) {
        return 0;
    }

}