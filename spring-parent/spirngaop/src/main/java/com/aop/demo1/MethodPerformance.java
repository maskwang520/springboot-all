package com.aop.demo1;
/**
 * 记录监视信息的类
 * @author maskwang
 *2017年6月19日
 */
public class MethodPerformance {
  private long begin;
  private long end;
  private String serviceMethod;
  public MethodPerformance(String serviceMethod){//记录开始时间
	  this.serviceMethod=serviceMethod;
	  begin=System.currentTimeMillis();
  }
  public void printPerformance(){//计算结束时间，顺便打印
	  end=System.currentTimeMillis();
	  long elapse=end-begin;
	  System.out.println(serviceMethod+"spend"+elapse+"毫秒");
  }
}
