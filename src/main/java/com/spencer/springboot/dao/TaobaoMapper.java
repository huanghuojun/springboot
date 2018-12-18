package com.spencer.springboot.dao;

import com.spencer.springboot.po.Taobao;

public interface TaobaoMapper {
    int deleteByPrimaryKey(String sign);

    int insert(Taobao record);

    int insertSelective(Taobao record);

    Taobao selectByPrimaryKey(String sign);

    int updateByPrimaryKeySelective(Taobao record);

    int updateByPrimaryKey(Taobao record);
}