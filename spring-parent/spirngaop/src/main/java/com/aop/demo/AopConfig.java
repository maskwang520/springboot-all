package com.aop.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
/**
 * 定义配置类
 * @author maskwang
 *2017年6月18日
 */
@Configuration
@ComponentScan("com.aop")
@EnableAspectJAutoProxy
public class AopConfig {

	

}
