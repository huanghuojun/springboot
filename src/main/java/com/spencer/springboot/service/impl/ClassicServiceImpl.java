package com.spencer.springboot.service.impl;

import com.spencer.springboot.dao.ClassicMapper;
import com.spencer.springboot.model.LikeInfo;
import com.spencer.springboot.po.Classic;
import com.spencer.springboot.service.IClassicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        Classic classic = classicMapper.selectLatest();
        return classic;
    }

    @Override
    public void updateStatus(int like_status, int id, int type) {
        classicMapper.updateStatus(like_status, id, type);
    }

    @Override
    public Classic selectByPrimaryKey(Integer id) {
        return classicMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Classic record) {
        return classicMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Classic record) {
        return classicMapper.updateByPrimaryKey(record);
    }

    @Override
    public Classic getNext(int index) {
        return classicMapper.selectNext(index);
    }

    @Override
    public Classic getPrevious(int index) {
        return classicMapper.selectPrevious(index);
    }

    @Override
    public LikeInfo getLikeIndo(int id, int type) {
        Classic classic = classicMapper.selectClassic(id, type);
        if (classic != null){
            LikeInfo likeInfo = new LikeInfo();
            likeInfo.setFavNums(classic.getFavNums());
            likeInfo.setId(classic.getId());
            likeInfo.setLikeStatus(classic.getLikeStatus());
            return likeInfo;
        }
        return null;
    }

    @Override
    public List<Classic> getMyPavor() {
        return classicMapper.findAll();
    }
}
