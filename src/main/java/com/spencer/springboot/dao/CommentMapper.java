package com.spencer.springboot.dao;

import com.spencer.springboot.po.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    List<Comment> selectByBookId(@Param("bookId") long id);

    Comment selectByContent(@Param("bookId") Long bookId, @Param("content") String content);
}