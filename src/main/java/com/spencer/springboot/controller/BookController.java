package com.spencer.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spencer.springboot.model.response.DataResponse;
import com.spencer.springboot.model.response.FavorCountResp;
import com.spencer.springboot.model.response.FavorResp;
import com.spencer.springboot.po.Book;
import com.spencer.springboot.po.Classic;
import com.spencer.springboot.po.Hot;
import com.spencer.springboot.service.IBookService;
import com.spencer.springboot.service.IClassicService;
import com.spencer.springboot.service.IHotService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;
import java.util.Random;

/**
 * @Author Spencer
 * @Date 2019/1/7 13:34
 * @Description
 */
@RestController
@RequestMapping("/book")
@Api("书籍管理")
public class BookController {

    private Logger logger = Logger.getLogger(ClassicController.class);

    @Autowired
    private IBookService bookService;

    @Autowired
    private IHotService hotService;

    @ApiOperation(value = "获取热门书籍(概要)", notes = "获取热门书籍(概要)")
    @RequestMapping(value = "/hot_list", method= RequestMethod.GET)
    @ResponseBody
    public DataResponse getHotList() {
        List<Book> list = bookService.getHotList();
        if(list != null){
            return new DataResponse(list, 200);
        }else{
            return new DataResponse("服务器异常", 201);
        }
    }

    @ApiOperation(value = "获取喜欢书籍数量", notes = "获取喜欢书籍数量")
    @RequestMapping(value = "/favor/count", method= RequestMethod.GET)
    @ResponseBody
    public DataResponse getFavorCount() {
        FavorCountResp favorCountResp = new FavorCountResp();
        Random random = new Random();
        favorCountResp.setCount(random.nextInt(9999));
        if(favorCountResp != null){
            return new DataResponse(favorCountResp, 200);
        }else{
            return new DataResponse("服务器异常", 201);
        }
    }

    @ApiOperation(value = "获取书籍详细信息", notes = "获取书籍详细信息")
    @ApiImplicitParam(name = "book_id", value = "书籍的id号", paramType = "path", required = true, dataType = "Integer")
    @RequestMapping(value = "/{book_id}/detail", method= RequestMethod.GET)
    @ResponseBody
    public DataResponse getDetail(@PathVariable("book_id") long bid) {
        Book data = bookService.selectByPrimaryKey(bid);
        if(data != null){
            return new DataResponse(data, 200);
        }else{
            return new DataResponse("服务器异常", 201);
        }
    }

    @ApiOperation(value = "获取书籍点赞情况", notes = "获取书籍点赞情况")
    @ApiImplicitParam(name = "book_id", value = "书籍的id号", paramType = "path", required = true, dataType = "Integer")
    @RequestMapping(value = "/{book_id}/favor", method= RequestMethod.GET)
    @ResponseBody
    public DataResponse getFavor(@PathVariable("book_id") long bid) {
        FavorResp favorResp = new FavorResp();
        Random random = new Random();
        int number = random.nextInt(9999);
        favorResp.setFavNums(number);
        favorResp.setLikeStatus(number%2 == 0 ? 1 : 0);
        if(favorResp != null){
            return new DataResponse(favorResp, 200);
        }else{
            return new DataResponse("服务器异常", 201);
        }
    }

    @ApiOperation(value = "获取热搜关键字", notes = "获取热搜关键字")
    @RequestMapping(value = "/hot_keyword", method= RequestMethod.GET)
    @ResponseBody
    public DataResponse getHotTag() {
        List<Hot> list = hotService.getHotKeyword();
        if(list != null){
            return new DataResponse(list, 200);
        }else{
            return new DataResponse("服务器异常", 201);
        }
    }


    @ApiOperation(value = "书籍搜索", notes = "书籍搜索")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "key", value = "搜索内容,比如你想搜索python相关书籍", paramType = "path", required = true, dataType = "String"),
        @ApiImplicitParam(name = "start", value = "开始记录数，默认为0", paramType = "path", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/search", method= RequestMethod.GET)
    @ResponseBody
    public DataResponse search(String key, int start) {
        logger.info("key = " + key+" ,start = "+start);
        PageHelper.startPage(start, 10);
        List<Book> list = bookService.searchKey(key);
        PageInfo<Book> pageInfo = new PageInfo<>(list);
        logger.info("key = " + key+" ,start = "+start+", list ="+pageInfo.getList().size());
        if(list != null){
            return new DataResponse(pageInfo, 200);
        }else{
            return new DataResponse("服务器异常", 201);
        }
    }
}
