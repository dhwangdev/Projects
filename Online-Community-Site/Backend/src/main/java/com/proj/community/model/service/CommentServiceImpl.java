package com.proj.community.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.community.model.dao.CommentDao;
import com.proj.community.model.dto.Comment;
import com.proj.community.model.dto.Recomment;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentDao commentDao;

	@Override
	public List<Comment> getComment(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return commentDao.readComment(map);
	}
	
	@Override
	public List<Recomment> getRecomment(int commentId) {
		// TODO Auto-generated method stub
		return commentDao.readRecomment(commentId);
	}
	
	@Override
	public List<Comment> getBest(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return commentDao.readBest(map);
	}

	@Override
	public List<Comment> searchByWriter(String nickname) {
		return commentDao.searchByWriter(nickname);
	}

	@Override
	public boolean addComment(Comment comment) {
		return commentDao.createComment(comment) == 1;
	}

	@Override
	public boolean modifyComment(Comment comment) {
		return commentDao.updateComment(comment) == 1;
	}

	@Override
	public boolean removeComment(int commentId) {
		return commentDao.deleteComment(commentId) == 1;
	}

	@Override
	public boolean addRecomment(Recomment recomment) {
		// TODO Auto-generated method stub
		return commentDao.createRecomment(recomment) == 1;
	}

	@Override
	public boolean modifyRecomment(Recomment recomment) {
		// TODO Auto-generated method stub
		return commentDao.updateRecomment(recomment) == 1;
	}

	@Override
	public boolean removeRecomment(int recommentId) {
		// TODO Auto-generated method stub
		return commentDao.deleteRecomment(recommentId) == 1;
	}
	
}
