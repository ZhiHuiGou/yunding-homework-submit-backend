package com.yundingshuyuan.web.common.exception;

import com.yundingshuyuan.web.common.vo.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常处理
 *
 * @Author cr
 * @Date 2023/7/22 13:27
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(SysException.class)
    public Result doSysException(SysException e){
        return new Result(e.getCode(),null,e.getMessage());
    }



    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException e){
        return new Result(e.getCode(),null,e.getMessage());
    }


    @ExceptionHandler(Exception.class)
    public Result doException(Exception e){
        return new Result(Result.SYSTEM_TIMEOUT_ERR,null,"访问超时");
    }
}
