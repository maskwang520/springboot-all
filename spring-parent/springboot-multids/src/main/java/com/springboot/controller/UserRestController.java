package com.springboot.controller;

import com.springboot.domain.City;
import com.springboot.domain.User;
import com.springboot.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制层
 *
 * Created by bysocket on 07/02/2017.
 */
@RestController
public class UserRestController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserService userService;

	/**
	 * Restful的查询用户
	 * @param userName
	 * @return
	 */
	@RequestMapping(value = "/api/user", method = RequestMethod.GET)
	public User findByName(@RequestParam(value = "userName", required = true) String userName) {
		User user = userService.findByName(userName);
//		logger.debug("This is a debug message");  
//        logger.info("This is an info message");  
//        logger.warn("This is a warn message");  
//        logger.error("This is an error message");  
		return user;
	}

}
