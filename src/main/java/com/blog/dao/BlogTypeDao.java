package com.blog.dao;

import com.blog.entity.BlogType;


//博客类别Dao接口
public interface BlogTypeDao {
	
	//根据id查找博客类型信息
	public BlogType findById(Integer id);

}
