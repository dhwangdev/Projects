package com.proj.community.model.service;

import java.util.List;
import java.util.Map;

import com.proj.community.model.dto.Comment;
import com.proj.community.model.dto.Recomment;

public interface CommentService {
	//댓글 리스트 불러오기(카테고리, 게시글id로 불러온다.)
	/**
	 * 
	 * @param category
	 * 댓글이 속한 게시글의 카테고리 ex) movie, book, sport..
	 * @param articleId
	 * 댓글이 속한 articleId
	 * @return
	 */
	public List<Comment> getComment(Map<String, Object> map);
	
	public List<Recomment> getRecomment(int commentId);
	
	public List<Comment> getBest(Map<String, Object> map);
	
	public List<Comment> searchByWriter(String nickname);
	
	//댓글 등록
	public boolean addComment(Comment comment);
	
	//댓글 수정
	public boolean modifyComment(Comment comment);
	
	//댓글 삭제
	public boolean removeComment(int commentId);
	
	// 대댓글 등록
	public boolean addRecomment(Recomment recomment);

	// 대댓글 수정
	public boolean modifyRecomment(Recomment recomment);
	
	// 대댓글 삭제
	public boolean removeRecomment(int recommentId);
	
}
