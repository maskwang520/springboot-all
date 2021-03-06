package com.springboot.controller;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.entity.DemoInfo;
import com.springboot.service.DemoInfoService;
import javassist.NotFoundException;

/**
 * @author maskwang
 * @version 2017年7月1日
 * controller层
 */
@RestController
public class DemoInfoController {
	@Resource
	private DemoInfoService demoInfoService;
	@RequestMapping("/test")
	public String test() {
		// 存入两条数据.
//		DemoInfo demoInfo = new DemoInfo();
//		demoInfo.setName("张三");
//		demoInfo.setPwd("123456");
//		DemoInfo demoInfo2 = demoInfoService.save(demoInfo);
//		// 不走缓存.
//		System.out.println(demoInfoService.findById(demoInfo2.getId()));
//		DemoInfo demoInfo3 = demoInfoService.save(demoInfo);
//		// 走缓存.
//		System.out.println(demoInfoService.findById(demoInfo3.getId()));
//		System.out.println("============修改数据=====================");
//		// 修改数据.
		DemoInfo updated = new DemoInfo();
		updated.setName("李四-updated");
		updated.setPwd("123456");
		updated.setId(9);
		try {
			System.out.println(demoInfoService.update(updated));
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(demoInfoService.findById(Long.valueOf(9)));
		System.out.println(demoInfoService.findById(Long.valueOf(9)));
//		// 不走缓存.
//		System.out.println(demoInfoService.findById(updated.getId()));
		return "ok";
	}
}
