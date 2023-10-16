package com.proj.community.model.service;

import java.util.List;

import com.proj.community.model.dto.Book;

public interface BookService {
	//전체조회 추천순
	public List<Book> getListByCategory(String category);
	
	//베스트셀러 랭킹순으로 조회
	/**
	 * 
	 * @param target
	 * all:전체 검색, title:제목검색, author: 작가검색
	 * @param word
	 * 검색할 단어
	 * @return
	 */
	public List<Book> search(String word);
	
	//책 하나 조회
	public Book get(int id);
	
	//책 등록
	public boolean add(Book book);
	
	//책 업데이트
	public boolean modify(Book book);
	
	//책 삭제
	public boolean remove(int id);
	
	public void getData(List<Book> bookList);
}
