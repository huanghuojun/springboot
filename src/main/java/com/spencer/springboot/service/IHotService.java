package com.spencer.springboot.service;

import com.spencer.springboot.po.Book;
import com.spencer.springboot.po.Hot;

import java.util.List;

/**
 * @Author Spencer
 * @Date 2019/1/7 16:21
 * @Description
 */
public interface IHotService {
    int insert(Hot record);

    int insertSelective(Hot record);

    List<Hot> getHotKeyword();
}
