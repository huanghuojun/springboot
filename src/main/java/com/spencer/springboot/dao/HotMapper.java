package com.spencer.springboot.dao;

import com.spencer.springboot.po.Hot;

import java.util.List;

public interface HotMapper {
    int insert(Hot record);

    int insertSelective(Hot record);

    List<Hot> findAllHotKeyword();
}