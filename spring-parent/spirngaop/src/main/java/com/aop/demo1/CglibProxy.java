package com.aop.demo1;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
/**
 * 通过cglib创建子类，从而拦截调用父类方法
 * @author maskwang
 * 
 *2017年6月19日
 */
public class CglibProxy implements MethodInterceptor {
	private Enhancer enhancer=new Enhancer();//定义子类
	public Object getProxy(Class clazz){   //创建子类
		enhancer.setSuperclass(clazz);//设置父类
		enhancer.setCallback(this);
		return enhancer.create();
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] arg2, MethodProxy proxy) throws Throwable {
		PerformanceMonitor.begin(obj.getClass().getName()+"."+method.getName());
		Object result=proxy.invokeSuper(obj, arg2);//调用父类方法
		PerformanceMonitor.end();
		return result;
	}

	
}
