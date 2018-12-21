package com.spencer.springboot.controller;

import com.spencer.springboot.form.LikeForm;
import com.spencer.springboot.model.response.DataResponse;
import com.spencer.springboot.po.Classic;
import com.spencer.springboot.service.IClassicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author Spencer
 * @Date 2018/12/20 11:04
 * @Description
 */
@RestController
@RequestMapping("/like")
@Api("点赞管理")
public class LikeController {

    private Logger logger = Logger.getLogger(ClassicController.class);

    @Autowired
    private IClassicService classicService;

    @ApiOperation(value = "取消点赞", notes = "取消点赞")
    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse likeCancel(@RequestBody @Valid LikeForm likeForm) {
        Classic classic = classicService.selectByPrimaryKey(likeForm.getArt_id());
        if (classic != null){
            classic.setLikeStatus(0);
            classic.setFavNums(classic.getFavNums() - 1);
        }
        int status = classicService.updateByPrimaryKey(classic);
        return new DataResponse("int = "+  status, 200);
    }

    @ApiOperation(value = "点赞", notes = "点赞")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse like(@RequestBody @Valid LikeForm likeForm) {
        Classic classic = classicService.selectByPrimaryKey(likeForm.getArt_id());
        if (classic != null){
            classic.setLikeStatus(1);
            classic.setFavNums(classic.getFavNums() + 1);
        }
        int status = classicService.updateByPrimaryKey(classic);
        return new DataResponse("int = "+  status, 200);
    }
}
