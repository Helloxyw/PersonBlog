package com.blog.entity;

public class Blogger {
	
	private Integer id; //博主的id
	private String username; //博主名字
	private String password; //博主密码
	private String profile; //博主信息
	private String nickname; //博主昵称
	private String sign;	//博主签名
	private String imagename; //博主头像路径
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "昵称:" + this.nickname + " 介绍" + this.profile; 
	}

	
}
