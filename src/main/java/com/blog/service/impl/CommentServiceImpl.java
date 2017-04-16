package com.blog.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.blog.dao.CommentDao;
import com.blog.entity.Comment;
import com.blog.service.CommentService;

@Service("commentService")
public class CommentServiceImpl implements CommentService {
	
	@Resource
	private CommentDao commentDao; 
	
	@Override
	public List<Comment> getCommentData(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return commentDao.getCommentData(map);
	}

	@Override
	public Integer addComment(Comment comment) {
		// TODO Auto-generated method stub
		return commentDao.addComment(comment);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return commentDao.getTotal(map);
	}

	@Override
	public Integer updateComment(Comment comment) {
		// TODO Auto-generated method stub
		return commentDao.updateComment(comment);
	}

	@Override
	public Integer deleteComment(Comment comment) {
		// TODO Auto-generated method stub
		return commentDao.deleteComment(comment);
	}

	@Override
	public Comment getComment(Integer id) {
		// TODO Auto-generated method stub
		return commentDao.getComment(id);
	}

	@Override
	public Integer deleteCommentByBlogId(Integer blogId) {
		// TODO Auto-generated method stub
		return commentDao.deleteCommentByBlogId(blogId);
	}

}
