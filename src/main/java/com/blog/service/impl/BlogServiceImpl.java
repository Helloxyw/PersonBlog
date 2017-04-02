package com.blog.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.BlogDao;
import com.blog.dao.BlogTypeDao;
import com.blog.entity.Blog;
import com.blog.service.BlogService;

@Service("blogService")
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogDao blogDao;
	@Autowired
	private BlogTypeDao blogTypeDao;
	
	@Override
	public Integer addBlog(Blog blog) {
		// TODO Auto-generated method stub
		return blogDao.addBlog(blog);
	}

	@Override
	public Integer updateBlog(Blog blog) {
		// TODO Auto-generated method stub
		return blogDao.updateBlog(blog);
	}

	@Override
	public Blog findById(Integer id) {
		// TODO Auto-generated method stub
		return blogDao.findById(id);
	}

	@Override
	public Integer deleteBlog(Blog blog) {
		// TODO Auto-generated method stub
		return blogDao.deleteBlog(blog);
	}

	@Override
	public List<Blog> listBlog(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return blogDao.listBlog(map);
	}

}
