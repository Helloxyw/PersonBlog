package com.blog.entity;

public class BlogType {

	private Integer id;
	private String typeName;
	private Integer orderNum;

	private Integer blogCount; // 统计不同类型博客数量

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Integer getBlogCount() {
		return blogCount;
	}

	public void setBlogCount(Integer blogCount) {
		this.blogCount = blogCount;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	@Override
	public String toString() {
		return "   The blogType.id :" + this.getId()+"; typeName :" + this.getTypeName() + ";orderNum : "
				+ this.getOrderNum();
	}

}
