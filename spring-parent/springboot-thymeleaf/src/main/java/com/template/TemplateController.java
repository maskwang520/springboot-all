package com.template;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试模板
 * 
 * @author maskwang 2017年6月10日
 */
@Controller
public class TemplateController {
	/**
	 * 返回html模板.默认是thymeleaf
	 */
	@RequestMapping("/helloHtml")
	public String helloHtml(Map<String, Object> map) {
		System.out.println("sb****");
		map.put("hello", "from TemplateController.helloHtml");
		return "helloHtml";
	}

	@RequestMapping("/helloFtl")
	public String helloFtl(Map<String, Object> map) {
		System.out.println("ftl");
		map.put("hello", "from TemplateController.helloFtl");
		return "helloFtl";
	}
}
