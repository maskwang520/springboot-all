package com;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;

import com.springboot.bean.BeanService;
@SpringBootApplication
@ServletComponentScan//这个就是扫描相应的Servlet包;
public class App {

	public static void main(String[] args) {

		ApplicationContext ctx =SpringApplication.run(App.class, args);
		//动态注入Bean
		//获取BeanFactory
		DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) ctx.getAutowireCapableBeanFactory();
		
		//创建bean信息.
		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(BeanService.class);
		beanDefinitionBuilder.addPropertyValue("name","张三");
		//动态注册bean.
		defaultListableBeanFactory.registerBeanDefinition("testService", beanDefinitionBuilder.getBeanDefinition());
		//注入第二个Bean
		beanDefinitionBuilder.addPropertyValue("name","李四");
		defaultListableBeanFactory.registerBeanDefinition("testService1", beanDefinitionBuilder.getBeanDefinition());
		//获取动态注册的bean.
		//BeanService testService =ctx.getBean(BeanService.class);
		BeanService testService =(BeanService) ctx.getBean("testService1");
		System.out.println(testService);
	}

}
