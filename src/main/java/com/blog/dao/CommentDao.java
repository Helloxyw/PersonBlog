package com.blog.dao;

import java.util.List;
import java.util.Map;

import com.blog.entity.Comment;

//评论接口
public interface CommentDao {

	//获取评论信息
	public List<Comment> getCommentData(Map<String,Object> map);
	
	//添加评论
	public Integer addComment(Comment comment);
	
	//获取总记录数
	public Long getTotal(Map<String,Object> map);
	
	//更新评论
	public Integer updateComment(Comment comment);

	//删除评论
	public Integer deleteComment(Comment comment);
	
	//根据ID获取评论
	public Comment getComment(Integer id);
	
	//用于删除博客之前先删除该评论，因为有外键
	public Integer deleteCommentByBlogId(Integer blogId);
}
