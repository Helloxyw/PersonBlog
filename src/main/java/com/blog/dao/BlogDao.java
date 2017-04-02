package com.blog.dao;

import java.util.List;
import java.util.Map;

import com.blog.entity.Blog;


//博客Dao接口

public interface BlogDao {
	
	//添加博客
	public Integer addBlog(Blog blog );

	//更新博客
	public Integer updateBlog(Blog blog);
	
	//删除博客
	public Integer deleteBlog(Blog blog);
	
	//根据id获取博客
	public Blog findById(Integer id);

	//分页查询博客
	public List<Blog> listBlog(Map<String, Object> map);
	
	
}
