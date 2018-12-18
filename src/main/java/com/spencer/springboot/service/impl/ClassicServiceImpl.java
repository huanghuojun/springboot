package com.spencer.springboot.service.impl;

import com.spencer.springboot.dao.ClassicMapper;
import com.spencer.springboot.po.Classic;
import com.spencer.springboot.service.IClassicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Spencer
 * @Date 2018/12/18 17:36
 * @Description
 */
@Service(value = "classicService")
public class ClassicServiceImpl implements IClassicService {

    @Autowired
    private ClassicMapper classicMapper;

    @Override
    public Classic getLatest() {
        Classic classic = classicMapper.selectByPrimaryKey(1);
        return classic;
    }
}
