package com.ldh.mapper;



/**
 * MyBatisBaseDao
 */

public interface MyBatisBaseDao<Model, PK >  {

    int deleteByPrimaryKey(PK id);

    int insert(Model record);

    int insertSelective(Model record);

    Model selectByPrimaryKey(PK id);

    int updateByPrimaryKeySelective(Model record);

    int updateByPrimaryKey(Model record);
}