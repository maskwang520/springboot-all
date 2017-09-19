package com.springboot.bean;

public class BeanService {
	 private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "BeanService [name=" + name + "]";
	}
	
}
