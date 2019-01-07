package com.spencer.springboot.dao;

import com.spencer.springboot.po.Classic;
import org.apache.ibatis.annotations.Param;

public interface ClassicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Classic record);

    int insertSelective(Classic record);

    Classic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Classic record);

    int updateByPrimaryKey(Classic record);

    void updateStatus(@Param("like_status") int like_status, @Param("id") int id, @Param("type") int type);

    Classic selectLatest();

    Classic selectNext(@Param("indexes") int index);

    Classic selectPrevious(@Param("indexes") int index);

    Classic selectClassic(@Param("id") int id, @Param("type") int type);
}