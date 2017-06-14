package com.maskwang;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常处理
 * 
 * @author maskwang
 *
 */
@ControllerAdvice
public class HandleException {
	@ExceptionHandler(value = Exception.class)
	public void handle(HttpServletRequest req, Exception e) {
		e.printStackTrace();
		System.out.println("error:maskwang");
	}

}
