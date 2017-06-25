package com.springboot;

import org.springframework.stereotype.Service;
/**
 * 位于App.java的子包或者同包下，能够扫描到
 * @author maskwang
 *2017年6月17日
 */
@Service
public class HelloService {

	public HelloService() {
		System.out.println("HelloService.HelloService()");
	    System.out.println("org.kfit.service.HelloService.HelloService()");
	    System.out.println("HelloService.HelloService()");
	}

}
