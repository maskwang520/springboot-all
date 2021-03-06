package com.test;
import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.App;
import com.springboot.TestService;

import junit.framework.Assert;

/// SpringJUnit支持，由此引入Spring-Test框架支持！
@RunWith(SpringJUnit4ClassRunner.class)

////指定我们SpringBoot工程的Application启动类
@SpringBootTest(classes = App.class)

///由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@WebAppConfiguration
public class ServiceTest {
	@Resource
	TestService testService;
	@Before
	public void beforeTest(){
		System.out.println("before***");
	}
	@Test
	public void getName(){
		Assert.assertEquals("maskwang",testService.getName());
	}
	
	

}
