package com.blog.controller;

import java.security.CryptoPrimitive;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blog.entity.Blogger;
import com.blog.util.CryptographyUtil;

@Controller
@RequestMapping("/blogger")
public class BloggerController {

	@RequestMapping("/login")
	public String login(Blogger blogger, HttpServletRequest request) {
		Subject subject = SecurityUtils.getSubject();// 获取当前登录主体
		// 将密码使用md5加密
		String newPassword = CryptographyUtil.md5(blogger.getPassword(),
				"javacoder");
		// 将信息封装到token中
		UsernamePasswordToken token = new UsernamePasswordToken(
				blogger.getUsername(), newPassword);
		try{
		subject.login(token); //会调用MyRealm中的doGetAuthenticationInfo方法进行身份认证
		return "redirect:/admin/main.jsp";
		}catch(AuthenticationException e){
			e.printStackTrace();
			request.setAttribute("blogger", blogger);
			request.setAttribute("errorInfo", "用户名或密码错误");
			return "login";
		}
	}
	
		
}
