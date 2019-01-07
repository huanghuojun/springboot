package com.spencer.springboot.service.impl;

import com.spencer.springboot.dao.BookMapper;
import com.spencer.springboot.dao.HotMapper;
import com.spencer.springboot.po.Hot;
import com.spencer.springboot.service.IHotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Spencer
 * @Date 2019/1/7 16:21
 * @Description
 */
@Service(value = "hotService")
public class IHotServiceImpl implements IHotService {

    @Autowired
    private HotMapper hotMapper;

    @Override
    public int insert(Hot record) {
        return hotMapper.insert(record);
    }

    @Override
    public int insertSelective(Hot record) {
        return hotMapper.insertSelective(record);
    }
}
