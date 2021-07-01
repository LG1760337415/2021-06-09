package com.liu.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class MyExceptionHandler {

//    @ExceptionHandler(value =Exception.class)
//	public BaseResult<String> exceptionHandler(Exception e){
//		System.out.println("未知异常！原因是:"+e);
//       	return new BaseResult<>(ResultCode.ERROR,"未知异常！原因是："+e.getMessage());
//    }
}