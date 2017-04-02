package com.blog.service;

import java.util.List;
import java.util.Map;

import com.blog.entity.Blog;

public interface BlogService {
	
	//分页查询博客
	public List<Blog> listBlog(Map<String,Object> map);
	
	//添加博客
	public Integer addBlog(Blog blog);
	
	//更新博客
	public Integer updateBlog(Blog blog);
	
	//查询博客
	public Blog findById(Integer id);
	
	//删除博客
	public Integer deleteBlog(Blog blog);
	
}
