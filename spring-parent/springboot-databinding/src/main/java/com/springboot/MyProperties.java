package com.springboot;

import org.springframework.boot.context.properties.ConfigurationProperties;
/**
 * 引入自定义的属性
 * @author maskwang
 *2017年6月15日
 */
@ConfigurationProperties(prefix = "maskwang") //如果不是application文件，须配置location属性
public class MyProperties {
	private String name;
	private String age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	

}
