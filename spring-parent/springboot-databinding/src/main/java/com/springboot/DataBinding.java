package com.springboot;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
/**
 * 读取环境变量
 * @author maskwang
 *2017年6月15日
 */
@Configuration
public class DataBinding implements EnvironmentAware {
	@Value("${spring:sbmask}") //@Value(“${key:defaultVlaue}”) 的形式进行设置。
	public String url;
	
	

	@Override
	public void setEnvironment(Environment environment) {
		System.out.println("databaseurl:" + url);
		System.out.println(environment.getProperty("JAVA_HOME"));
		System.out.println(environment.getProperty("spring.datasource.url"));
		RelaxedPropertyResolver relaxedPropertyResolver = new RelaxedPropertyResolver(environment,"spring.datasource.");
		System.out.println("spring.datasource.url=" + relaxedPropertyResolver.getProperty("url"));
		System.out.println("spring.datasource.driverClassName=" + relaxedPropertyResolver.getProperty("driverClassName"));

	}

}
