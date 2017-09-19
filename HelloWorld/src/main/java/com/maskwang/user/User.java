package com.maskwang.user;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class User {
	private int id;
	//name属性定义输出的名称
	private String name;
	private Date date;
	@JSONField(name = "Dates")
	public Date getDate() {
		return date;
	}
    @JSONField(name = "Dates")
	public void setDate(Date date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
