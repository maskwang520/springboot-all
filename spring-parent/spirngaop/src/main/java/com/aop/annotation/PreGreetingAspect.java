package com.aop.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect()
public class PreGreetingAspect {
	@Before("args(java.lang.String)")
	public void beforeGreeting(){
		System.out.println("How are you");
	}
}
