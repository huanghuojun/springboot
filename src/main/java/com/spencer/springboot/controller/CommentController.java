package com.spencer.springboot.controller;

import com.spencer.springboot.form.AddCommentForm;
import com.spencer.springboot.model.response.CommentResp;
import com.spencer.springboot.model.response.DataResponse;
import com.spencer.springboot.po.Comment;
import com.spencer.springboot.service.ICommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author Spencer
 * @Date 2019/1/7 16:28
 * @Description
 */
@RestController
@RequestMapping("/comment")
@Api("短评管理")
public class CommentController {

    private Logger logger = Logger.getLogger(ClassicController.class);

    @Autowired
    private ICommentService commentService;

    @ApiOperation(value = "获取书籍短评", notes = "获取书籍短评")
    @ApiImplicitParam(name = "book_id", value = "书籍的id,必填,必须为正整数", paramType = "path", required = true, dataType = "Integer")
    @RequestMapping(value = "/{book_id}/short_comment", method= RequestMethod.GET)
    @ResponseBody
    public DataResponse getShortComment(@PathVariable("book_id") long bid) {
        List<Comment> commentList = commentService.selectByBookId(bid);
        CommentResp commentResp = new CommentResp();
        commentResp.setCommentList(commentList);
        commentResp.setBookId(bid);
        if(commentResp != null){
            return new DataResponse(commentResp, 200);
        }else{
            return new DataResponse("没有热门书籍", 201);
        }
    }


    @ApiOperation(value = "新增短评", notes = "新增短评")
    @RequestMapping(value = "/add/short_comment", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse addComment(@RequestBody @Valid AddCommentForm addCommentForm) {
        Comment comment = commentService.selectByContent(addCommentForm.getBook_id(), addCommentForm.getContent());
        if (comment != null){
            comment.setNums(comment.getNums()+1);
            commentService.updateByPrimaryKey(comment);
        }else{
            comment = new Comment();
            comment.setNums(1l);
            comment.setBookId(addCommentForm.getBook_id());
            comment.setContent(addCommentForm.getContent());
            commentService.insert(comment);
        }
        return new DataResponse("", 200);
    }
}

