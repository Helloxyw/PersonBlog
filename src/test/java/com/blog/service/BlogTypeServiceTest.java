package com.blog.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blog.entity.BlogType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-service.xml",
		"classpath:spring/spring-dao.xml"})
public class BlogTypeServiceTest {

	@Resource
	private BlogTypeService blogTypeService;
	
	@Test
	public void testAddBlogType(){
		
		BlogType blogType = new BlogType();
		blogType.setTypeName("诗歌");
		blogTypeService.addBlogType(blogType);
	}
	
	@Test
	public void testUpdateBlogType(){
		Integer id = 1003;
		BlogType blogType = blogTypeService.findById(id);
		blogType.setTypeName("影视");
		blogTypeService.updateBlogType(blogType);
	}
	
	@Test
	public void testListBlogType(){
		Map map = new HashMap<String, Object>();
		map.put("start", 0);
		map.put("pageSize", 5);
		List<BlogType> list = blogTypeService.listBlogType(map);
		for (BlogType blogType : list) {
			System.out.println(blogType);
		}
	}
	
	@Test
	public void testGetBlogTypeData(){
		List<BlogType> list = blogTypeService.getBlogTypeData();
		for (BlogType blogType : list) {
			System.out.println(blogType);
		}
	}
}
