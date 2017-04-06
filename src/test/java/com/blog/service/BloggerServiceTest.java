package com.blog.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blog.dao.BloggerDao;
import com.blog.entity.Blogger;

/*
 * 配置spring和junit整合,junit启动时加载springIOC容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({ "classpath:/spring/spring-dao.xml",
		"classpath:/spring/spring-service.xml" })
public class BloggerServiceTest {

	@Resource
	private BloggerService bloggerService;

	@Resource
	private BloggerDao bloggerDao;

	@Test
	public void testGetByUsername() {

		String username = "xyw";

		System.out.println(bloggerService.getByUsername(username));
	}
	
	@Test
	public void testGetBloggerData(){
		System.out.println(bloggerService.getBloggerData());
	}
	
	@Test
	public void testUptdaBlogger(){
		Blogger blogger = new Blogger();
		blogger.setProfile("IT小菜鸟");
		blogger.setSign("一人我饮酒醉");
		bloggerService.updateBlogger(blogger);
		
	}
}
