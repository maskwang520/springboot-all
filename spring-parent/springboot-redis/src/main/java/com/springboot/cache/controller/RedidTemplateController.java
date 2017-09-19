package com.springboot.cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author maskwang
 * @version 2017年7月12日
 * 
 */
@RestController
public class RedidTemplateController {
	@Autowired
	RedisTemplate redisTemplate;

	@RequestMapping("/saveString")
	public Object saveString() {
		// 添加一个 key
		// ValueOperations<String, Object> value = redisTemplate.opsForValue();
		// value.set("lp","hello");//添加 一个 hash集合
		// HashOperations<String, Object, Object> hash =
		// redisTemplate.opsForHash();
		// Map<String,Object> map = new HashMap<String,Object>();
		// map.put("name", "lp");
		// map.put("age", "26");
		// hash.putAll("lpMap", map);

		// ListOperations<String, Object> list = redisTemplate.opsForList();
		// list.rightPush("lpList", "lp");
		// list.rightPush("lpList", "26");
		SetOperations<String, Object> set = redisTemplate.opsForSet();
		set.add("lpSet", "lp");
		set.add("lpSet", "26");
		set.add("lpSet", "178cm");
		//添加有序的 set 集合
//        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
//        zset.add("lpZset", "lp", 0);
//        zset.add("lpZset", "26", 1);
//        zset.add("lpZset", "178cm", 2);
        System.out.println(set.members("lpSet"));
		return set.members("lpSet");
	}

}
