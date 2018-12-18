package com.spencer.springboot.controller;

import com.spencer.springboot.model.response.DataResponse;
import com.spencer.springboot.po.Classic;
import com.spencer.springboot.service.IClassicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Spencer
 * @Date 2018/12/14 10:53
 * @Description
 */
@Api("文章API")
@RestController
@RequestMapping("/classic")
public class ClassicController {

    private Logger logger = Logger.getLogger(ClassicController.class);

    @Autowired
    private IClassicService classicService;
//    @ApiImplicitParam(name = "id", value = "学生ID", paramType = "path", required = false, dataType = "Integer")

    @ApiOperation(value = "根据id查询学生信息", notes = "查询数据库中某个的学生信息")
    @RequestMapping(value = "/latest", method= RequestMethod.GET)
    @ResponseBody
    public DataResponse getLatest() {
        Classic classic = classicService.getLatest();
        if(classic != null){
            System.out.println("classic.getContent():" + classic.getContent());
            logger.info("classic.getTitle():" + classic.getTitle());
        }
        return new DataResponse(classic, 200);
    }

}
