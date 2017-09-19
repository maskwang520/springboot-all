package com.maskwang;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常处理
 * @author maskwang
 *2017年7月11日
 */
@ControllerAdvice
public class HandleException {
	@ExceptionHandler(value = ArithmeticException.class)
	public void handle(HttpServletRequest req, Exception e) {
		System.out.println("error:maskwang");
	}

}
