package com.blog.controller.admin;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.entity.Blog;
import com.blog.lucene.BlogIndex;
import com.blog.service.BlogService;
import com.blog.util.ResponseUtil;
import com.mysql.fabric.Response;

@Controller
@RequestMapping("/admin/blog")  //restful API设计原则
public class BlogAdminController {

	@Resource
	private BlogService blogService;

	private BlogIndex blogIndex = new BlogIndex();
	// 更新和添加博客
	@RequestMapping("/save")
	public String save(Blog blog, HttpServletResponse response) throws Exception {
		int resultTotal = 0;// 接受返回结果数
		
		if(blog.getId()==null){ //说明是第一次插入
			resultTotal = blogService.addBlog(blog);
			blogIndex.addIndex(blog);//添加博客索引
		
		}else{  //有id表示有修改
			resultTotal = blogService.updateBlog(blog);
			blogIndex.updateIndex(blog); //更新博客索引
			
		}
		
		JSONObject result = new JSONObject();
		if(resultTotal>0){
			result.put("success", true);
		}else{
			result.put("success", false);
		}
		
		ResponseUtil.write(response, result);
		
		return null;
	}

	// 后台分页查询博客
	@RequestMapping("/listBlog")
	public String listBlog(
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "row", required = false) String row,
			Blog blog, HttpServletResponse response) {

		return null;
	}

	// 博客信息删除
	@RequestMapping("/delete")
	public String delete(
			@RequestParam(value = "id", required = false) String id,
			HttpServletResponse response){ 
		return null;
	}

	// 通过id获取博客
	@RequestMapping("findById")
	public String findById(
			@RequestParam(value = "id", required = false) String id,
			HttpServletResponse response) {
		return null;
	}
}
