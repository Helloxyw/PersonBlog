package com.blog.util;

//字符串工具类
public class StringUtil {

	// 判断字符是否为空
	public static boolean isEmpty(String str) {
		// trim()方法返回调用字符串对象的一个副本,但是所有起始和结尾的空格都被删除了
		if (str == null || "".equals(str.trim())) {
			return true;
		} else {
			return false;
		}
	}

	// 判断字符是否不为空
	public static boolean isNoEmpty(String str) {
		if (str == null || "".equals(str.trim())) {
			return false;
		} else {
			return true;
		}
	}
	
	public static String formatLike(String str){
		if(isNoEmpty(str)){
			return "%" + str+"%";
		}else{
			return null;
		}
	}
}
