package com.springboot.servlet;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
/**
 * 定义session监听器
 * @author maskwang
 *2017年6月12日
 */
@WebListener
public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("session is created***");

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("session is destoried***");

	}

}
