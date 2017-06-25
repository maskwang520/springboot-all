package com.aop.demo1;
/**
 * 性能监视的实现类
 * @author maskwang
 *2017年6月19日
 */
public class PerformanceMonitor {
	private static ThreadLocal<MethodPerformance> pr=new ThreadLocal<>();
	public static void begin(String method){
		System.out.println("begin monitor...");
		MethodPerformance mp=new MethodPerformance(method);
		pr.set(mp);
	}
	public static void end(){
		System.out.println("end monitor...");
		MethodPerformance mp=pr.get();//记录的是同一个线程的信息
		mp.printPerformance();
	}
}
