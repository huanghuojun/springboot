package com.spencer.springboot.service;

import com.spencer.springboot.model.LikeInfo;
import com.spencer.springboot.po.Classic;

/**
 * @Author Spencer
 * @Date 2018/12/18 17:36
 * @Description
 */
public interface IClassicService {

    Classic getLatest();

    void updateStatus(int like_status, int id, int type);

    Classic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Classic record);

    int updateByPrimaryKey(Classic record);

    Classic getNext(int index);

    Classic getPrevious(int index);

    LikeInfo getLikeIndo(int id, int type);

}
