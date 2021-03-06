package com.aop.demo1;

/**
 * 业务逻辑的实现，//在此的性能监视被抽离出去了，只有纯粹的逻辑代码
 * @author maskwang
 *2017年6月19日
 */
public class ForumServiceImpl implements ForumService {

	@Override
	public void removeTopic(int topicId) {
		//在此的性能监视被抽离出去了
		System.out.println("模拟删除Topic记录："+topicId);
		try {
			Thread.currentThread().sleep(20);
		} catch (InterruptedException e) {
			throw new RuntimeException();
		};
		//在此的性能监视被抽离出去了

	}

	@Override
	public void removeForum(int forumId) {
		//在此的性能监视被抽离出去了
		System.out.println("模拟删除Topic记录："+forumId);
		try {
			Thread.currentThread().sleep(40);
		} catch (InterruptedException e) {
			throw new RuntimeException();
		};
		//在此的性能监视被抽离出去了
	}

}
