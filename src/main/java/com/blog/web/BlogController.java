package com.blog.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//把类放容器中
@RequestMapping("/blog")
public class BlogController {

	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String show(Model model){
		
		model.addAttribute("message","hello,springmvc success!");
		return "test";
		
	}
	
	
}
