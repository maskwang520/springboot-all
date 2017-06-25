package com.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 把自定义属性类注入进来
 * @author maskwang
 *2017年6月15日
 */
@Controller
public class TestController {
	@Autowired
	MyProperties myProperties;
	@RequestMapping("/test")
	@ResponseBody
	public MyProperties getMyProperties(){
		return myProperties;
	}

}
