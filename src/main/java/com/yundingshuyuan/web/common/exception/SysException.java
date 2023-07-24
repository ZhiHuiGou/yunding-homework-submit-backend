package com.yundingshuyuan.web.common.exception;

/**
 * @Author cr
 * @Date 2023/7/22 13:27
 */
public class SysException extends RuntimeException{
    private  Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public SysException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public SysException(String message, Throwable cause, Integer code) {
        super(message, cause);
        this.code = code;
    }


}
