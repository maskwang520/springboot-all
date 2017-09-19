package com.aop.annotation;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

import com.aop.demo2.NaiveWaiter;
import com.aop.demo2.Waiter;

public class AspectJProxyTest {

	public static void main(String[] args) {
		Waiter target=new NaiveWaiter();
		AspectJProxyFactory factory=new AspectJProxyFactory();
		//设置目标对象
		factory.setTarget(target);
		//设置切面 
		factory.addAspect(PreGreetingAspect.class);
		//生成代理对象
		Waiter waiter=factory.getProxy();
		waiter.serveTo("john");
		waiter.greetTo("john");

	}

}
