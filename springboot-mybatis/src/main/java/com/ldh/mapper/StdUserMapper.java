package com.ldh.mapper;

import java.util.List;

import com.ldh.entity.StdUser;

import org.springframework.stereotype.Repository;

/**
 * StdUserMapper
 */
@Repository
public interface StdUserMapper extends MyBatisBaseDao<StdUser, Integer> {
    /** 查询所有 */
    List<StdUser> GetUsers();
}