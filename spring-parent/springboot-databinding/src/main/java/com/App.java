package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;

import com.springboot.MyProperties;
@SpringBootApplication
@ServletComponentScan  //扫描到servlet
@EnableConfigurationProperties({MyProperties.class})  
public class App {

	public static void main(String[] args) {

		SpringApplication.run(App.class, args);
	}

}
