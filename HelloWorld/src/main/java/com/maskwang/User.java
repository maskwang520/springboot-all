package com.maskwang;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class User {
	private int id;
	@JSONField(serialize = false)
	private String name;
	private Date date;

	public Date getDate() {
		return date;
	}

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
