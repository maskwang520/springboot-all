package com.aop.demo2;

import org.springframework.aop.framework.ProxyFactory;
/**
 * 环绕增强，即在方法执行前后都执行增强逻辑
 * @author maskwang
 *2017年6月19日
 */

public class TestInterceptor {
	public static void main(String []args){
		Waiter target=new NaiveWaiter();
		GreetingInterceptor gi=new GreetingInterceptor();
		ProxyFactory pf=new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvice(gi);
		Waiter proxy=(Waiter) pf.getProxy(); 
		proxy.serveTo("mask");
	}
}
