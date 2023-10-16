package com.proj.community.model.dao;

import java.util.List;
import java.util.Map;

import com.proj.community.model.dto.Comment;
import com.proj.community.model.dto.Recomment;

public interface CommentDao {
	// 댓글 리스트 불러오기(카테고리, 게시글id로 불러온다.)
	/**
	 * 
	 * @param category  댓글이 속한 게시글의 카테고리 ex) movie, book, sport..
	 * @param articleId 댓글이 속한 게시글의 id
	 * @return
	 */
	public List<Comment> readComment(Map<String, Object> map);

	// 대댓글 불러오기, 댓글아이디로
	public List<Recomment> readRecomment(int commentId);

	// 댓글 베스트3
	public List<Comment> readBest(Map<String, Object> map);

	// 작성자 찾기(댓글, 대댓글포함 최신순으로)
	public List<Comment> searchByWriter(String nickname);

	// 댓글 등록
	public int createComment(Comment comment);

	// 댓글 수정
	public int updateComment(Comment comment);

	// 댓글 삭제
	public int deleteComment(int commentId);

	// 대댓글 등록
	public int createRecomment(Recomment recomment);

	// 대댓글 수정
	public int updateRecomment(Recomment recomment);
	
	// 대댓글 삭제
	public int deleteRecomment(int recommentId);

}
