package com.blog.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class ResponseUtil {

	public static void write(HttpServletResponse response,Object obj) throws Exception{
		response.setCharacterEncoding("text/html;charset=utf-8");
		PrintWriter out = response.getWriter(); //获取输出流,输出内容到网页上
		out.println(obj.toString());
		out.flush();
		out.close();
	}
}
