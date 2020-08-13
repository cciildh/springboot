package com.ldh.service;

import java.util.List;

import com.ldh.entity.StdUser;

/**
 * StdUserService
 */
public interface StdUserService {

    List<StdUser> selAll();

    StdUser selById(Integer userid);

    int insert(StdUser user);

    int updateById(StdUser user);

    int deleteById(Integer userid);
}