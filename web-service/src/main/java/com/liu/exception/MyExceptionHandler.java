package com.liu.exception;

import com.liu.entity.BaseResult;
import com.liu.entity.ResultCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value =Exception.class)
	public BaseResult<String> exceptionHandler(Exception e){
		System.out.println("未知异常！原因是:"+e);
       	return new BaseResult<>(ResultCode.ERROR,"未知异常！原因是："+e.getMessage());
    }
}