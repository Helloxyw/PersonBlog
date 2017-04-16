package com.blog.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blog.entity.Blog;

/*
 * 配置spring和junit整合,junit启动时加载springIOC容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({ "classpath:/spring/spring-dao.xml",
		"classpath:/spring/spring-service.xml" })
public class BlogServiceTest {

		@Resource 
		private BlogService blogService;
		
		@Test
		public void testFindById(){
			Integer id = 2;
			Blog blog = blogService.findById(id);
			System.out.println(blog);
		}
	
}
