package com.aop.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/**
 * 定义横切逻辑，通过反射调用目标方法，动态的将横切逻辑和业务逻辑编织在一起
 * 编织器
 * @author maskwang
 *2017年6月19日
 */
public class PerformanceHandle implements InvocationHandler {
    private Object target;//目标业务类
    public PerformanceHandle(Object target){
    	this.target=target;
    }
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		PerformanceMonitor.begin(target.getClass().getName()+method.getName());
		Object obj=method.invoke(target, args);//调用目标方法
		PerformanceMonitor.end();
		return null;
	}

}
