package com.blog.entity;


//分页Model类
public class PageBean {

	private Integer page;  //第几页
	private Integer pageSize;	//分页大小
	private Integer start;	//起始页
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	
}
