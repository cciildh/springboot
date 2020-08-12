package com.ldh.service.impl;

import java.util.List;

import com.ldh.entity.StdUser;
import com.ldh.mapper.StdUserMapper;
import com.ldh.service.StdUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * StdUserServiceImpl
 */
@Service
public class StdUserServiceImpl implements StdUserService {

    @Autowired
    private StdUserMapper stdusermapperimpl;



    @Override
    public List<StdUser> selAll() {
        return stdusermapperimpl.selAll();
    }

    @Override
    public StdUser selById(Integer userid) {
        return stdusermapperimpl.selectByPrimaryKey(userid);
    }

  

}