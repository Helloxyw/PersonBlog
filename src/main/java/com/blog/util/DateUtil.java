package com.blog.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


//日期工具类
public class DateUtil {

	//日期对象转字符串
	public static String formatDate(Date date,String format){
		String result = "";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		if(date!=null){
			result = sdf.format(date);
		}
		return result;
	}
	
	
	//字符串转日期
	public static Date formatString(String str,String format) throws ParseException{
		if(StringUtil.isEmpty(str)){
			return null;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.parse(str);
	}
	
	//获取当前日期字符串
	public static String  getCurrentDateStr(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		return sdf.format(date);
	}
}
