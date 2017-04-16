package com.blog.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.blog.dao.BlogTypeDao;
import com.blog.entity.Blog;
import com.blog.entity.BlogType;
import com.blog.service.BlogTypeService;

@Service("blogTypeService")
public class BlogTypeServiceImpl implements BlogTypeService {

	@Resource
	private BlogTypeDao blogTypeDao;

	@Override
	public BlogType findById(Integer id) {
		// TODO Auto-generated method stub
		return blogTypeDao.findById(id);
	}

	@Override
	public List<BlogType> getBlogTypeData() {
		// TODO Auto-generated method stub
		return blogTypeDao.getBlogTypeData();
	}

	@Override
	public List<BlogType> listBlogType(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return blogTypeDao.listBlogType(map);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return blogTypeDao.getTotal(map);
	}

	@Override
	public Integer addBlogType(BlogType blogType) {
		// TODO Auto-generated method stub
		return blogTypeDao.addBlogType(blogType);
	}

	@Override
	public Integer updateBlogType(BlogType blogType) {
		// TODO Auto-generated method stub
		return blogTypeDao.updateBlogType(blogType);
	}

	@Override
	public Integer deleteBlogType(BlogType blogType) {
		// TODO Auto-generated method stub
		return blogTypeDao.deleteBlogType(blogType);
	}
	
	

}
