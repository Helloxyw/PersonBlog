package com.blog.util;

import org.apache.shiro.crypto.hash.Md5Hash;

//md5加密工具类
public class CryptographyUtil {

	//使用Shiro中的md5加密
	public static String md5(String str,String salt){
		//md5Hash是Shiro中的一个方法
		return new Md5Hash(str, salt).toString();
	}
	
	public static void main(String[] args) {
		String password = "123456";
		System.out.println("md5加密:" + md5(password, "javacoder"));
		System.out.println("md5加密:" + md5("123456","javacoder"));
	} 
}
