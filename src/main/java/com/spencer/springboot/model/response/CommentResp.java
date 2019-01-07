package com.spencer.springboot.model.response;

import com.spencer.springboot.po.Comment;

import java.util.List;

/**
 * @Author Spencer
 * @Date 2019/1/7 16:53
 * @Description
 */
public class CommentResp {
    public List<Comment> commentList;
    public long bookId;

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }
}
