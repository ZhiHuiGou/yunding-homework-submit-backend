package com.yundingshuyuan.web.common.vo;

import lombok.Data;

/**
 * @Author cr
 * @Date 2023/7/22 11:06
 */
@Data
public class Result<T> {

    private Integer code;
    private T data;
    private String message;

    /**
     * 常量
     */
    public static final Integer PROJECT_BUSINESS_ERR = 50001;
    public static final Integer SYSTEM_TIMEOUT_ERR = 50002;
    public static final Integer SYSTEM_UNKNOW_ERR =50003;


    static final Integer SUCCESS_CODE = 200;
    static final Integer FAILURE_CODE = -1;
    static final String SUCCESS_MESSAGE = "操作成功";
    static final String FAILURE_MESSAGE = "操作失败";

    /**
     * 构造器
     */

    public Result(Integer code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result() {
    }

    /**
     * 将返回值进行包装，成功
     */
    public static <T> Result<T> success(){
        return new Result<>(SUCCESS_CODE,null,SUCCESS_MESSAGE);
    }
    public static <T> Result<T> successWithData(T data){
        return new Result<>(SUCCESS_CODE,data,SUCCESS_MESSAGE);
    }
    public static <T> Result<T> successWithoutData(String message){
        return new Result<>(SUCCESS_CODE,null,message);
    }
    /**
     * 将返回值进行包装，失败
     */
    public static <T> Result<T> failure(){
        return new Result<>(FAILURE_CODE,null,FAILURE_MESSAGE);
    }
    public static <T> Result<T> failureWithData(T data){
        return new Result<>(FAILURE_CODE,data,FAILURE_MESSAGE);
    }
    public static <T> Result<T> failureWithoutData(String message){
        return new Result<>(FAILURE_CODE,null,message);
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
