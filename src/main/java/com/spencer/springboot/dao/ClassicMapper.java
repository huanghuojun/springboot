package com.spencer.springboot.dao;

import com.spencer.springboot.po.Classic;

public interface ClassicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Classic record);

    int insertSelective(Classic record);

    Classic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Classic record);

    int updateByPrimaryKey(Classic record);
}