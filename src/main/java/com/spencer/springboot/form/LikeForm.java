package com.spencer.springboot.form;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author Spencer
 * @Date 2018/12/18 18:53
 * @Description
 */
@ApiModel("点赞信息")
@Getter
@Setter
public class LikeForm {
    @ApiModelProperty("点赞对象,例如你想对电影进行点赞，那这个参数就是电影的id号")
    private int art_id;
    @ApiModelProperty("点赞类型分为四种：100 电影 200 音乐 300 句子 400 书籍")
    private int type;
}

