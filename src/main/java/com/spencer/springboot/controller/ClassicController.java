package com.spencer.springboot.controller;

import com.spencer.springboot.model.LikeInfo;
import com.spencer.springboot.model.response.DataResponse;
import com.spencer.springboot.po.Classic;
import com.spencer.springboot.service.IClassicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Spencer
 * @Date 2018/12/14 10:53
 * @Description
 */
@RestController
@RequestMapping("/classic")
@Api("文章管理")
public class ClassicController {

    private Logger logger = Logger.getLogger(ClassicController.class);

    @Autowired
    private IClassicService classicService;

    @ApiOperation(value = "获取我喜欢的期刊", notes = "获取我喜欢的期刊")
    @RequestMapping(value = "/favor", method= RequestMethod.GET)
    @ResponseBody
    public DataResponse getMyFavor() {
        List<Classic> list = classicService.getMyPavor();
        if(list != null){
            return new DataResponse(list, 200);
        }else{
            return new DataResponse("没有喜欢期刊", 201);
        }
    }

    @ApiOperation(value = "获取最新一期", notes = "获取最新一期")
    @RequestMapping(value = "/latest", method= RequestMethod.GET)
    @ResponseBody
    public DataResponse getLatest() {
        Classic classic = classicService.getLatest();
        if(classic != null){
            return new DataResponse(classic, 200);
        }else{
            return new DataResponse("没有最新期刊", 201);
        }
    }

    @ApiOperation(value = "获取当前一期的下一期", notes = "获取当前一期的下一期")
    @ApiImplicitParam(name = "index", value = "期号,必填,必须是正整数", paramType = "path", required = true, dataType = "Integer")
    @RequestMapping(value = "/{index}/next", method= RequestMethod.GET)
    @ResponseBody
    public DataResponse getNext(@PathVariable("index") int index) {
        Classic classic = classicService.getNext(index+1);
        if(classic != null){
            return new DataResponse(classic, 200);
        }else{
            return new DataResponse("没有当前一期的下一期期刊", 201);
        }
    }

    @ApiOperation(value = "获取当前一期的上一期", notes = "获取当前一期的上一期")
    @ApiImplicitParam(name = "index", value = "期号,必填,必须是正整数", paramType = "path", required = true, dataType = "Integer")
    @RequestMapping(value = "/{index}/previous", method= RequestMethod.GET)
    @ResponseBody
    public DataResponse getPrevious(@PathVariable("index") int index) {
        Classic classic = classicService.getPrevious(index-1);
        if(classic != null){
            return new DataResponse(classic, 200);
        }else{
            return new DataResponse("没有当前一期的上一期期刊", 201);
        }
    }

    @ApiOperation(value = "获取点赞信息", notes = "获取点赞信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "必填, 点赞对象的id号", paramType = "path", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "type", value = "必填, 点赞类型", paramType = "path", required = true, dataType = "Integer"),
    })
    @RequestMapping(value = "/{type}/{id}/favor", method= RequestMethod.GET)
    @ResponseBody
    public DataResponse getPrevious(@PathVariable("id") int id,@PathVariable("type") int type) {
        LikeInfo likeInfo = classicService.getLikeIndo(id, type);
        if(likeInfo != null){
            return new DataResponse(likeInfo, 200);
        }else{
            return new DataResponse("没有点赞信息", 201);
        }
    }
}
