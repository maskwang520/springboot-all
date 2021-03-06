package com.springboot.cache.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.springboot.cache.RedisUtils;
import com.springboot.cache.entity.UserEntity;
import com.springboot.cache.jpa.UserJPA;

/**
 * 实现服务接口，调用UserJPA里面的API就可以
 * 
 * @author maskwang 2017年6月23日
 */
// @CacheConfig(cacheNames="user")用来表示该类都存储在同一个cache
@Service
public class UserService {

	@Autowired
	private UserJPA userJPA;

	// 分页实现，它会查出来有多少条记录，然后用limit实现
	public List<UserEntity> list(PageRequest pageRequest) {
		return userJPA.findAll(pageRequest).getContent();
	}

	// 清除str缓存上的缓存，是all缓存
	@CacheEvict(cacheNames = "str", allEntries = true)
	// @Caching(evict = { @CacheEvict("primary"),
	// @CacheEvict(cacheNames="secondary", key="#p0") })
	// 来精确缓存位置
	// 无分页
	public List<UserEntity> listWithoutPage() {
		return userJPA.findAll();
	}

	// 找到其中一个
	@Cacheable(value = "oneuser")
	public UserEntity findOne(long id) {
		return userJPA.findOne(id);
	}

	// 自定义sql语句查询
	public List<UserEntity> findAllByAge(int age) {
		return userJPA.nativeQuery(age);
	}

	// 利用SpEL实现对缓存的控制,只有满足name为aaa时候缓存
	@Cacheable(value = "users", condition = "#name=='aaa'")
	public List<UserEntity> findAllByName(String name) {
		return userJPA.nativeQueryByName(name);
	}

	// 不管参数是否相同，都会执行方法，并且把结果存到redis中去
	@CachePut(value = "str")
	public String findAllString(String keystr) {
		String str = "maskwang";
		System.out.println("first");
		return str;
	}

	// 自定义更新用户，一定要加上事务处理的注解，@Transactional
	public int updateUser(int id) {
		return userJPA.updateUser(id);
	}
}
