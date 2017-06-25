package com.aop.demo2;


import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactory;
/**
 * 后置增强
 * @author maskwang
 *2017年6月19日
 */
public class TestAfterAdvice {
   public static void main(String []args){
   AfterReturningAdvice ar= new GreetingAfterAdvice();
   ProxyFactory proxy=new ProxyFactory();
   Waiter waiter=new NaiveWaiter();
   proxy.setTarget(waiter);
   proxy.addAdvice(ar);
   Waiter proxyBean=(Waiter) proxy.getProxy();
   proxyBean.greetTo("mask");
   }
}
