package com.aop.demo2;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
/**
 * 采用jdk的代理，在构造代理对象的时候会比cglib快，但是，但是在调用方法的时候，
 * 使用cglib比jdk快
 * @author maskwang
 *2017年6月19日
 */
public class TestBeforeAdvice {

	public static void main(String[] args) {
		Waiter target=new NaiveWaiter();
		BeforeAdvice advice=new GreetingBeforeAdvice();
		//spring 提供的代理工厂
		ProxyFactory pf=new ProxyFactory();
		//使用jdk的代理技术
		pf.setInterfaces(target.getClass().getInterfaces());
		pf.setOptimize(true);
		//设置代理目标
		pf.setTarget(target);
		//为代理目标添加增强
		pf.addAdvice(advice);
		//生成代理实例
		Waiter proxy=(Waiter)pf.getProxy();
		proxy.greetTo("mask");
		proxy.serveTo("mask");

	}

}
