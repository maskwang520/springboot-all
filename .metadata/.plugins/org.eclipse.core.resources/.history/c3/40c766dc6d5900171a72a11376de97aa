package com.springboot;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 测试jsp
 * @author maskwang
 *2017年6月11日
 */
@Controller
public class JspController {
	@Value("${application.hello:Hello Angel}")
	private String hello;
	@RequestMapping("/test")
	public String testJsp(Map<String,Object> map){
		map.put("name","maskwang");
		System.out.println(hello);
		return "index";
	}

}
