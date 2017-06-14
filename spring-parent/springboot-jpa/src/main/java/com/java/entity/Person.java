package com.java.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * hibernate根据类结构反向生成表
 * @author maskwang
 *2017年6月10日
 */
@Table(name="person")
@Entity
public class Person {
	@Id @GeneratedValue
    private long id;//主键.
    private String name;//测试名称.
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    

}
