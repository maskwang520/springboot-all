package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
@SpringBootApplication
@ServletComponentScan  //扫描到servlet，此处扫描Durid过滤器。
public class App {

	public static void main(String[] args) {

		SpringApplication.run(App.class, args);
	}

}
