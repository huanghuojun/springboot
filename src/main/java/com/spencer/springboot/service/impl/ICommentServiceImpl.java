package com.spencer.springboot.service.impl;

import com.spencer.springboot.dao.BookMapper;
import com.spencer.springboot.dao.CommentMapper;
import com.spencer.springboot.po.Comment;
import com.spencer.springboot.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Spencer
 * @Date 2019/1/7 16:21
 * @Description
 */
@Service(value = "commentService")
public class ICommentServiceImpl implements ICommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return commentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Comment record) {
        return commentMapper.insert(record);
    }

    @Override
    public int insertSelective(Comment record) {
        return commentMapper.insertSelective(record);
    }

    @Override
    public Comment selectByPrimaryKey(Long id) {
        return commentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Comment record) {
        return commentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Comment record) {
        return commentMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Comment> selectByBookId(Long id) {
        return commentMapper.selectByBookId(id);
    }

    @Override
    public Comment selectByContent(Long bookId, String content) {
        return commentMapper.selectByContent(bookId, content);
    }
}
