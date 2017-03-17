package com.blog.dao;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blog.entity.Blog;
import com.blog.entity.BlogType;


/*
 * 配置spring和junit整合,junit启动时加载springIOC容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:/spring/spring-dao.xml"})
public class BlogDaoTest {
	
	//注入Dao实现类依赖
	@Resource
	private BlogDao blogDao;
	
	
	
	
	@Test
	public void testAddBlog(){
		
		BlogType blogType = new BlogType();
		blogType.setId(1000);
		blogType.setTypeName("java类别");
//		blogType.setBlogCount(blogCount);
		blogType.setOrderNum("1");
		
		Blog blog = new Blog();
		blog.setTitle("这是个标题");
		blog.setSummary("这是个摘要");
		blog.setRelaseDate(new Date());
		blog.setClickHit(0);
		blog.setReplyHit(0);
		blog.setContent("这是个内容");
		blog.setKeyWord("这是关键字");
		blog.setBlogType(blogType);
		
		System.out.println(blog.toString());
		
		blogDao.addBlog(blog);
		
	}

}
