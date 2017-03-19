package com.blog.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.blog.service.BlogService;

@Controller
public class BlogController {
	
	@Resource
	private BlogService blogService;

}
