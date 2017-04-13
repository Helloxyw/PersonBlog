package com.blog.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

import com.blog.entity.Blog;
import com.blog.service.BlogService;

@Controller
@RequestMapping("/blog")
public class BlogController {
	
	@Resource
	private BlogService blogService;
	
	//请求博客详细信息
	@RequestMapping("/articles/{id}")
	public ModelAndView details(@PathVariable("id")Integer id,HttpServletRequest request){
		
		ModelAndView modelAndView = new ModelAndView();
		Blog blog = blogService.findById(id);  //获取博客
		
		//获取关键字
		String keyWord = blog.getKeyWord();
		
		modelAndView.addObject("blog", blog);
		
		blog.setClickHit(blog.getClickHit()+1); //将访问量加一
		blogService.updateBlog(blog); //更新博客
		
		
		//查询评论信息
		
		//返回视图
		modelAndView.setViewName("blogList");
		
		return modelAndView;
		
	}
	

}
