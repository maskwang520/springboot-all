package com.aop.demo1;

import java.lang.reflect.Proxy;

/**
 * 创建代理实例(采用jdk的动态代理)
 * Proxy(目标类的类加载器，目标类实现的接口，InvocationHandle的实例）
 * @author maskwang
 *2017年6月19日
 */
public class TestFrumService {

	public static void main(String[] args) {
		Object obj=new Object();
		ForumService fs=new ForumServiceImpl();//实例
		PerformanceHandle ph=new PerformanceHandle(fs);//把逻辑代码编织到横切逻辑中
		ForumService proxy=(ForumService) Proxy.newProxyInstance(fs.getClass().getClassLoader(),fs.getClass().getInterfaces(),ph);
		proxy.removeForum(10);
		proxy.removeTopic(1024);

	}

}
