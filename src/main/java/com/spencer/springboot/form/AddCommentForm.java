package com.spencer.springboot.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author Spencer
 * @Date 2019/1/7 17:11
 * @Description
 */
@ApiModel("新增短评")
@Getter
@Setter
public class AddCommentForm {
    @ApiModelProperty("书籍id")
    private long book_id;
    @ApiModelProperty("评论内容,我们可允许的评论内容范围为12字以内")
    private String content;
}
