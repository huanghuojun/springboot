package com.spencer.springboot.service;

import com.spencer.springboot.po.Book;

import java.util.List;

/**
 * @Author Spencer
 * @Date 2019/1/7 13:35
 * @Description
 */
public interface IBookService {
    int deleteByPrimaryKey(Long id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    List<Book> getHotList();
}
