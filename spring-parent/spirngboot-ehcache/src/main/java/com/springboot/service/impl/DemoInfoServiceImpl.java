package com.springboot.service.impl;

import javax.annotation.Resource;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.springboot.dao.DemoInfoRespository;
import com.springboot.entity.DemoInfo;
import com.springboot.service.DemoInfoService;
import javassist.NotFoundException;

/**
 * @author maskwang
 * @version 2017年7月1日
 * service实现类，在这里具体实现缓存
 */
@Service
public class DemoInfoServiceImpl implements DemoInfoService {
	@Resource
	private DemoInfoRespository demoInfoRespository;
	public static final String CACHE_KEY = "'demoInfo'";
	public static final String DEMO_CACHE_NAME = "demo";
    //清除DEMO_CACHE_NAME缓存里面key为demoInfo_+入参id
	@CacheEvict(value = DEMO_CACHE_NAME, key = "'demoInfo_'+#id") // 这是清除缓存.
	@Override
	public void delete(Long id) {
		demoInfoRespository.delete(id);

	}
    //更新DEMO_CACHE_NAME缓存里面key为demoInfo_+入参id
	@CachePut(value = DEMO_CACHE_NAME, key = "'demoInfo_'+#updated.getId()")
	@Override
	public DemoInfo update(DemoInfo updated) throws NotFoundException {
		DemoInfo demoInfo = demoInfoRespository.findOne(updated.getId());
		if (demoInfo == null) {
			throw new NotFoundException("demoInfo is null");
		}
		demoInfo.setName(updated.getName());
		demoInfo.setPwd(updated.getPwd());
		return demoInfo;
	}
    //缓存DEMO_CACHE_NAME缓存里面key为demoInfo_+入参id
	@Cacheable(value = DEMO_CACHE_NAME, key = "'demoInfo_'+#id")
	@Override
	public DemoInfo findById(Long id) {
        System.out.println("缓存查找findById");
		return demoInfoRespository.findOne(id);
	}
	//清除DEMO_CACHE_NAME缓存里面key为demoInfo_+入参id
	@CacheEvict(value = DEMO_CACHE_NAME, key = CACHE_KEY)
	@Override
	public DemoInfo save(DemoInfo demoInfo) {
		return demoInfoRespository.save(demoInfo);
	}
	

}
