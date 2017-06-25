package com.springboot.cache.entity;

import java.io.Serializable;

/** 
* @author maskwang
* @version 2017年6月24日 
* 
*/
public class PageInfo implements Serializable {
	protected int page=1;
	protected int size=1;
	protected String sidx="id";
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getSidx() {
		return sidx;
	}
	public void setSidx(String sidx) {
		this.sidx = sidx;
	}
	
		
	
}