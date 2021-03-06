package com.spencer.springboot.dao;

import com.spencer.springboot.po.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    List<Book> findAllBook();

    List<Book> searchBook(@Param("key") String key);
}