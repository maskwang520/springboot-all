package com.aop.demo2;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class GreetingAfterAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnobj, Method method, Object[] arg2, Object arg3) throws Throwable {
		System.out.println("enjoy youself");
		
	}
   
}
