package com.springboot.cache.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.cache.entity.UserEntity;
import com.springboot.cache.service.UserService;

/**
 * 测试服务
 * 
 * @author maskwang 2017年6月24日
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 简单查询用户列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "/list")
	public List<UserEntity> list() {
		return userService.listWithoutPage();
	}

	/**
	 * 根据主键查询
	 * 
	 * @param id
	 * @return
	 */

	@RequestMapping("/findone/{id}")
	public UserEntity findone(@PathVariable("id") long id) {
		return userService.findOne(id);
	}

	/**
	 * 自定义查询，根据年龄大小
	 * 
	 * @return
	 */
	@RequestMapping(value = "/findallbyage")
	public List<UserEntity> findAllByAge() {
		return userService.findAllByAge(1);
	}

	@RequestMapping(value = "/findallbyname")
	public List<UserEntity> findAllByName() {
		return userService.findAllByName("bbb");
	}

	/**
	 * 根据年龄更新用户，自定义的
	 * 
	 * @return
	 */
	@RequestMapping(value = "/updateUser")
	public int updateUser() {
		return userService.updateUser(1);
	}

	@RequestMapping(value = "/findallstr")
	public String getAllStr() {

		return userService.findAllString("mask");
	}

	// 实现分页
	@RequestMapping(value = "/cutpage")
	public List<UserEntity> findAll() {
		UserEntity user = new UserEntity();// 继承的好处
		user.setPage(1);
		user.setSize(1);
		PageRequest pageRequest = new PageRequest(user.getPage(), user.getSize());
		return userService.list(pageRequest);
	}

}
