package com.spencer.springboot.dao;

import com.spencer.springboot.po.Hot;

public interface HotMapper {
    int insert(Hot record);

    int insertSelective(Hot record);
}