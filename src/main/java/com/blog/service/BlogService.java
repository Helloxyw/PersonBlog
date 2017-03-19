package com.blog.service;

import com.blog.entity.Blog;

public interface BlogService {
	
	//添加博客
	public Integer addBlog(Blog blog);
	
	//更新博客
	public Integer updateBlog(Blog blog);
	
	//查询博客
	public Blog findById(Integer id);
	
	//删除博客
	public Integer deleteBlog(Blog blog);
	
}
