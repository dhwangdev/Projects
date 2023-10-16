package com.proj.community.model.dao;

import java.util.List;

import com.proj.community.model.dto.Article;

public interface ArticleDao {
	/**
	 * 게시글을 조회한다.
	 * @param category
	 * all:전체, none:카테고리 없음, joke:유머, chat:잡담, info:정보
	 * @param searchTarget
	 * all:전체, none:검색안함, title:제목검색, writer:글쓴이검색, content:내용검색
	 * @param word
	 * 검색단어
	 * @param sortTarget
	 * none:최신순정렬, view:조회수정렬, recommend:추천순정렬, comment:댓글순정렬
	 * @param direction
	 * ASC:오름차순, DESC:내림차순
	 * @return
	 */
	public List<Article> search(String category, String searchTarget, String word);
	
	//게시글 전체 조회 최신순
	public List<Article> readAll();
	
	//게시글 작성자로 찾기
	public List<Article> searchByWriter(String nickname);
	
	//게시글 하나 조회
	public Article read(int id);
	
	//게시글 생성
	public int create(Article article);
	
	//게시글 업데이트
	public int update(Article article);
	
	//게시글 삭제
	public int delete(int id);
	
	public List<Article> readCategory(String category, String sortTarget);
	
	
}
