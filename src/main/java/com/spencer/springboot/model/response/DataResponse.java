package com.spencer.springboot.model.response;

/**
 * @Author Spencer
 * @Date 2018/12/14 11:28
 * @Description
 */
public class DataResponse<T> extends BaseResponse {
    public T data;

    public DataResponse(){}

    public DataResponse(T data, String desc, int status) {
        super(desc,status);
        this.data = data;
    }

    public DataResponse(T data, int status) {
        super("", status);
        this.data = data;
    }

    public DataResponse(String desc, int status) {
        super(desc,status);
    }
}
