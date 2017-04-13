package com.blog.controller.admin;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.blog.entity.Blogger;
import com.blog.service.BloggerService;
import com.blog.util.CryptographyUtil;
import com.blog.util.DateUtil;
import com.blog.util.ResponseUtil;

@Controller
@RequestMapping("/admin/blogger")
public class BloggerAdminController {

	@Resource
	private BloggerService bloggerService;

	// 查询博主信息
	@RequestMapping("/findBlogger")
	public String findBlogger(HttpServletResponse response) throws Exception {
		Blogger blogger = bloggerService.getBloggerData();
		JSONObject result = JSONObject.fromObject(blogger);
		ResponseUtil.write(response, result);
		return null;
	}

	// 修改博主信息
	@RequestMapping("/save")
	public String save(@RequestParam("imageFile") MultipartFile imageFile,
			Blogger blogger, HttpServletRequest request,
			HttpServletResponse response) throws Exception, Exception {

		if (!imageFile.isEmpty()) { // 如果用户上传了图片就更新
			// 获取服务器根路径
			String filePath = request.getServletContext().getRealPath("/"); 
			//编辑图片名
			String imageName = DateUtil.getCurrentDateStr() + "."
					+ imageFile.getOriginalFilename().split("\\.")[1];
			
			imageFile.transferTo(new File(filePath+"static/userImages/"+imageName));
			blogger.setImagename(imageName);
		}
		
		int resultTotal = bloggerService.updateBlogger(blogger);
		JSONObject result = new JSONObject();
		if(resultTotal>0){
			result.put("success", true);
		}else{
			result.put("success", false);
		}

		ResponseUtil.write(response, result);
		return null;

	}

	// 修改博主密码
	@RequestMapping("/modifyPassword")
	public String modifyPassword(HttpServletResponse response,
			@RequestParam("password") String password) throws Exception { // @RequestParam参数绑定

		Blogger blogger = bloggerService.getBloggerData();
		blogger.setPassword(CryptographyUtil.md5(password, "javacoder"));
		int resultTotal = bloggerService.updateBlogger(blogger);
		JSONObject result = new JSONObject();
		if (resultTotal > 0) {
			result.put("success", true);
		} else {
			result.put("success", false);
		}

		ResponseUtil.write(response, result);
		return null;

	}

	// 退出
	@RequestMapping("/logout")
	public String logout() {
		SecurityUtils.getSubject().logout();
		return "redirect:/login.jsp";
	}
}
