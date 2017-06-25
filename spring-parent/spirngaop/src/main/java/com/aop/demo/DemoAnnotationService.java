package com.aop.demo;

import org.springframework.stereotype.Service;
/**
 * 使用自定义注解的类
 * @author maskwang
 *2017年6月18日
 */
@Service
public class DemoAnnotationService {
   @Action(name = "注解式拦截的add操作")
   public void add(){}
}
