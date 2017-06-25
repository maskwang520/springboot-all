package com.aop.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
/**
 * 通过主类，调用容器管理的Bean
 * @author maskwang
 *2017年6月18日
 */
public class Main {

	public static void main(String []args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext("AopConfig.class");
		DemoAnnotationService das=(DemoAnnotationService) context.getBean("DemoAnnotationService.class");
		DemoMethodService dms=(DemoMethodService) context.getBean("DemoMethodService.class");
		das.add();
		dms.add();
		context.close();
	}

}

