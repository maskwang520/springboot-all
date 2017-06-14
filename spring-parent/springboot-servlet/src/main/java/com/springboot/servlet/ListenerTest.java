package com.springboot.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
/**
 * 定义监听器
 * @author maskwang
 *2017年6月12日
 */
@WebListener
public class ListenerTest implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("destory***");

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("init***");

	}

}
