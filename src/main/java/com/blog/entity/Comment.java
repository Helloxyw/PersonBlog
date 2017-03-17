package com.blog.entity;

import java.util.Date;

public class Comment {
	
	private Integer id;
	private Integer userIp; //评论者IP
	private String content; //评论内容
	private Date commentDate; //评论时间
	private Integer state; //审核状态
	private Blog blog; //要评论的博客
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserIp() {
		return userIp;
	}
	public void setUserIp(Integer userIp) {
		this.userIp = userIp;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	
	
}
