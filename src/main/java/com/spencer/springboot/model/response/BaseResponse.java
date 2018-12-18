package com.spencer.springboot.model.response;

/**
 * @Author Spencer
 * @Date 2018/12/14 11:27
 * @Description
 */
public class BaseResponse {
    public String msg;
    public int code;

    public BaseResponse(){}

    public BaseResponse(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }
}
