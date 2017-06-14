package com.springboot.servlet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
/**
 * spring boot 启动时候加载
 * @author maskwang
 *2017年6月13日
 */
@Order(value=2)
@Component
public class MyStartUpRunner2 implements CommandLineRunner {

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("myStartupRunner2***");

	}

}
