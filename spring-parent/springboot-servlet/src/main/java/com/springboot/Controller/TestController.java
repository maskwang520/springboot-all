package com.springboot.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 * 
 * @author maskwang 2017年6月12日
 */
@RestController
public class TestController {
	@RequestMapping("/user")
	public String test(HttpServletRequest req) throws InterruptedException {//测试建立session和请求
		HttpSession session=req.getSession();
		session.setAttribute("user", "maskwang");
		Thread.currentThread().sleep(3000);
		session.invalidate();
		return "hello maskwang";
	}
}
