package com.maskwang.service;

import org.springframework.stereotype.Service;

/** 
* @author maskwang
* @version 2017年7月11日 
* 
*/
@Service
public class ExceptionService {
	public void  getExcepiton() throws ArithmeticException{
		int i = 100 / 0;
	}
}
