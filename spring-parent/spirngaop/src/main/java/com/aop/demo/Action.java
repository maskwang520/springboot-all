package com.aop.demo;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)//作用的对象
@Retention(RetentionPolicy.RUNTIME)  //该注解可以由虚拟机保存
@Documented  //被javadoc等工具记录
public @interface Action {
  String name();
}
