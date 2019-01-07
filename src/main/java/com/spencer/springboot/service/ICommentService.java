package com.spencer.springboot.service;

import com.spencer.springboot.po.Comment;

import java.util.List;

/**
 * @Author Spencer
 * @Date 2019/1/7 16:21
 * @Description
 */
public interface ICommentService {
    int deleteByPrimaryKey(Long id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    List<Comment> selectByBookId(Long id);

    Comment selectByContent(Long bookId, String content);
}
