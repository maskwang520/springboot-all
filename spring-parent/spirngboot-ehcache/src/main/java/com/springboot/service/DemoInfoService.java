package com.springboot.service;

import com.springboot.entity.DemoInfo;

import javassist.NotFoundException;

/** 
* @author maskwang
* @version 2017年7月1日 
* dao层
*/
public interface DemoInfoService {
	void delete(Long id);
	 
    DemoInfo update(DemoInfo updated) throws NotFoundException;
 
 
    DemoInfo save(DemoInfo demoInfo);

	DemoInfo findById(Long id);
}
