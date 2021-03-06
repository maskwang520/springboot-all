package com.springboot.cache.jpa;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.springboot.cache.entity.UserEntity;

/**
 * JpaRepository实现Create、Read、Update、Delete的接口，用户继承该类就行， 里面的方法已经具备了
 * 
 * @author maskwang 2017年6月23日
 */
public interface UserJPA extends JpaRepository<UserEntity, Long> {
	// 定义自定义查询
	@Query(value = "select * from t_user where t_age=?1", nativeQuery = true)
	public List<UserEntity> nativeQuery(int age);

	@Query(value = "select * from t_user where t_name=?1", nativeQuery = true)
	public List<UserEntity> nativeQueryByName(String name);

	@Transactional
	@Modifying
	@Query(value = "update t_user set t_age=100 where t_id=?1", nativeQuery = true)
	public int updateUser(int id);

}
