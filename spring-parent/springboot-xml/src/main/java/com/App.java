package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@ServletComponentScan//这个就是扫描相应的Servlet包;
//@ComponentScan(basePackages={"cn.spring"})也可以在这里指定扫描的包，这样HelloService2就可以注入
public class App {

	public static void main(String[] args) {

		SpringApplication.run(App.class, args);
	}

}
