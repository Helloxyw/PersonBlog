package com.blog.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.blog.dao.BloggerDao;
import com.blog.entity.Blog;
import com.blog.entity.Blogger;
import com.blog.service.BlogService;
import com.blog.service.BloggerService;

@Service("BloggerService")
public class BloggerServiceImpl implements BloggerService {

	@Resource
	private BloggerDao bloggerDao;
	
	//根据用户名查询博主信息，用于登录
	@Override
	public Blogger getByUsername(String username) {
		// TODO Auto-generated method stub
			
		return bloggerDao.getByUsername(username);
	}

	@Override
	public Blogger getBloggerData() {
		// TODO Auto-generated method stub
		return bloggerDao.getBloggerData();
	}

	@Override
	public Integer updateBlogger(Blogger blogger) {
		// TODO Auto-generated method stub
		return bloggerDao.updateBlogger(blogger);
	}

	
}
