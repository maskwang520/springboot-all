package com.aop.demo2;
/**
 * 实现了Waiter接口
 * @author maskwang
 *2017年6月19日
 */
public class NaiveWaiter implements Waiter {

	@Override
	public void greetTo(String name) {
		System.out.println("greeting to"+name+"...");

	}

	@Override
	public void serveTo(String name) {
		System.out.println("serving"+name+"...");
		

	}

}
