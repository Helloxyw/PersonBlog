package com.blog.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.blog.entity.Blog;
import com.blog.entity.PageBean;
import com.blog.service.BlogService;
import com.blog.util.StringUtil;

@Controller
@RequestMapping("/")
public class IndexController {

	@Resource
	private BlogService blogService;

	// 请求主页
	@RequestMapping("/index")
	public ModelAndView index(
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "typeId", required = false) String typeId,
			@RequestParam(value = "releaseDateStr", required = false) String releaseDateStr,
			HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(StringUtil.isEmpty(page)){
			page = "1";
		}
		
		//获取分页的bean，每页显示10条数据
		PageBean pageBean = new PageBean(Integer.parseInt(page), 10);
		
		//map中封装起始页和每页的记录
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("start", pageBean.getStart());
		map.put("pageSize", pageBean.getPageSize());
		map.put("typeId", typeId);
		map.put("releaseDateStr", releaseDateStr);
		
		//获取博客信息
		List<Blog> blogList = blogService.listBlog(map);
		
		for(Blog blog: blogList){
			List<String> imageList = blog.getImageList();
			String blogInfo = blog.getContent(); //获取博客内容
			Document doc =  Jsoup.parse(blogInfo);
			
		}
		
		
		return null;
	}
}
