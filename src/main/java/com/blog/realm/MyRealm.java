package com.blog.realm;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.blog.entity.Blogger;
import com.blog.service.BloggerService;

public class MyRealm extends AuthorizingRealm {

	@Resource
	private BloggerService bloggerService;

	// 为当前登录用户授予角色和权限
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		// 个人博客没有这一项，因为就一个管理员用户
		return null;
	}

	// 对当前登录用户进项身份证认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		String username = (String) token.getPrincipal();// 获取用户名
		Blogger blogger = bloggerService.getByUsername(username);// 根据用户名从数据库中查询出博主

		if (blogger != null) {
			// 把当前用户存到session中
			SecurityUtils.getSubject().getSession()
					.setAttribute("current", blogger);
			AuthenticationInfo auInfo = new SimpleAuthenticationInfo(
					blogger.getUsername(), blogger.getPassword(), "MyRealm");
			return auInfo;
		} else {

			return null;
		}
	}
}
