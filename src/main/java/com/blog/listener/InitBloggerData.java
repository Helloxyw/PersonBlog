package com.blog.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.blog.entity.Blogger;
import com.blog.service.BloggerService;

@Component
// 注解 把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>
public class InitBloggerData implements ServletContextListener,
		ApplicationContextAware {
	// ApplicationContext可以在服务器启动的时候自动实例化所有的bean
	private static ApplicationContext applicationContext;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub

		applicationContext = WebApplicationContextUtils
				.getWebApplicationContext(sce.getServletContext());

		System.out.println(applicationContext);

		// 先获取servlet上下文
		ServletContext application = sce.getServletContext();

		// 根据spring的上下文获取bloggerService 这个bean
		BloggerService bloggerService = (BloggerService) applicationContext
				.getBean("bloggerService");

		// 获取博主信息
		Blogger blogger = bloggerService.getBloggerData();
		// 清空密码信息
		blogger.setPassword(null);
		// 将博主信息存到application域中
		application.setAttribute("blogger", blogger);

		// 同上获取博客类别信息

	}

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		// TODO Auto-generated method stub
		InitBloggerData.applicationContext = arg0;
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

}
