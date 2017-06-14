package com.maskwang;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mask")
public class UserController {
	@RequestMapping("/user")
	public User getUser() {// ����json��ʽ
		User user = new User();
		user.setId(100);
		user.setName("masksb");
		user.setDate(new Date());
		return user;
	}

	// �����쳣����
	@RequestMapping("/error")
	public void errorTest() {
		int i = 100 / 0;
	}
}
