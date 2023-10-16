package com.proj.community.model.dao;

import java.util.List;

import com.proj.community.model.dto.Book;

public interface BookDao {
	//전체조회 추천순
	//만약 베스트셀러라면? 랭킹순 조회
	//Bestseller or newItem 
	public List<Book> readCategory(String category);
	
	//검색 추천순
	public List<Book> search(String word);
	
	//책 하나 조회
	public Book read(int id);
	
	//책 등록
	public int create(Book book);
	
	//책 업데이트
	public int update(Book book);
	
	//책 삭제
	public int delete(int id);
}

	