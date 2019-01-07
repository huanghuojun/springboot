package com.spencer.springboot.service;

import com.spencer.springboot.po.Hot;

/**
 * @Author Spencer
 * @Date 2019/1/7 16:21
 * @Description
 */
public interface IHotService {
    int insert(Hot record);

    int insertSelective(Hot record);
}
