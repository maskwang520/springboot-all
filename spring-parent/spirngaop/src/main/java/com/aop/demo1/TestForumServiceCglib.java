package com.aop.demo1;
/**
 * jdk动态代理的缺点是，必须要有实现接口，而cglib却不需要
 * @author maskwang
 *2017年6月19日
 */
public class TestForumServiceCglib {
	public static void main(String []args){
	CglibProxy cp=new CglibProxy();
	//创建代理实例，向其中织入业务代码
	ForumService fs=(ForumService) cp.getProxy(ForumServiceImpl.class);
	fs.removeForum(10);
	fs.removeTopic(1024);
	
	
	}
	
}
