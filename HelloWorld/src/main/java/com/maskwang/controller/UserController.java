package com.maskwang.controller;

import com.alibaba.fastjson.JSONObject;
import com.maskwang.service.ExceptionService;
import com.maskwang.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/mask")
public class UserController {
	@Autowired
	ExceptionService exceptionService;
	@RequestMapping("/user")
	public String getUser() {
		User user = new User();
		user.setId(100);
		user.setName("masksb");
		user.setDate(new Date());
		String jsonString= JSONObject.toJSONString(user);
		User user1=JSONObject.toJavaObject(JSONObject.parseObject(jsonString),User.class);
		System.out.println(user1.getDate()+"*******");
		return jsonString;
	}

	//会发生异常
	@RequestMapping("/error")
	public void errorTest() {
		exceptionService.getExcepiton();
	}

	@RequestMapping("/hello")
	public String hello() {
		return "hello mask";
	}
}
