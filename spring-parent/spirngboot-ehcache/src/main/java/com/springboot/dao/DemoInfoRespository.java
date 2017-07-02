package com.springboot.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.entity.DemoInfo;

/** 
* @author maskwang
* @version 2017年7月1日 
* 实现CrudRepository实现crud操作
*/
public interface DemoInfoRespository extends CrudRepository<DemoInfo,Long> {

}
