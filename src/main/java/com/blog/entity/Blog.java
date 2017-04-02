package com.blog.entity;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Blog {

	private Integer id;
	private String title;
	private String summary;
	private Date relaseDate;
	private Integer clickHit; // 点击次数
	private Integer replyHit; // 回复次数
	private String content; // 内容

	private String contentNoTag; // 不带标签的博客内容,用于Lucene索引
	private String keyWord; // 关键字,用空格隔开

	private BlogType blogType; // 博客类型
	private Integer blogCount; // 博客数量,非博客实际属性,用于根据发布日期归档查询
	private String relaseDateStr; // 发布日期的字符串，只取年月

	// 博客里存的照片，用于显示缩略图
	private List<String> imageList = new LinkedList<String>(); 

	public List<String> getImageList() {
		return imageList;
	}

	public void setImageList(List<String> imageList) {
		this.imageList = imageList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Date getRelaseDate() {
		return relaseDate;
	}

	public void setRelaseDate(Date relaseDate) {
		this.relaseDate = relaseDate;
	}

	public Integer getClickHit() {
		return clickHit;
	}

	public void setClickHit(Integer clickHit) {
		this.clickHit = clickHit;
	}

	public Integer getReplyHit() {
		return replyHit;
	}

	public void setReplyHit(Integer replyHit) {
		this.replyHit = replyHit;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContentNoTag() {
		return contentNoTag;
	}

	public void setContentNoTag(String contentNoTag) {
		this.contentNoTag = contentNoTag;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public BlogType getBlogType() {
		return blogType;
	}

	public void setBlogType(BlogType blogType) {
		this.blogType = blogType;
	}

	public Integer getBlogCount() {
		return blogCount;
	}

	public void setBlogCount(Integer blogCount) {
		this.blogCount = blogCount;
	}

	public String getRelaseDateStr() {
		return relaseDateStr;
	}

	public void setRelaseDateStr(String relaseDateStr) {
		this.relaseDateStr = relaseDateStr;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "The blog title:" + this.getTitle() + ",summary : "
				+ this.getSummary() + "blogType : "
				+ this.getBlogType().toString();
	}

}
