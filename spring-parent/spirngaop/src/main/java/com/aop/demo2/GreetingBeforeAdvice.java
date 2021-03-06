package com.aop.demo2;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
/**
 * 定义前置增强接口
 * @author maskwang
 *2017年6月19日
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice {
    //method是目标方法，arg1代表的是参数，arg2代表的目标类实例
	@Override
	public void before(Method method, Object[] arg1, Object arg2) throws Throwable {
		String clientName=(String)arg1[0];
		System.out.println("How are you!Mr."+clientName+".");
		System.out.println(arg2);

	}

}
