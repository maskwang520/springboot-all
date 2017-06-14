package com.springboot.servlet;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
/**
 * 设置启动时候，就加载的数据
 * @author maskwang
 *2017年6月13日
 */
@Order(value=1)
@Component
public class MyStartUpRunner1 implements CommandLineRunner {
    
	@Override
	public void run(String... arg0) throws Exception {
		System.out.println(Arrays.asList(arg0));
		System.out.println("MyStartupRunner1****");

	}

}