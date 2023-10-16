package com.proj.community.model.dao;

import java.util.List;

import com.proj.community.model.dto.Movie;

public interface MovieDao {
	//전체 조회(추천순 정렬해서 보내준다.)
	public List<Movie> readAll();
	
	//제목검색
	public List<Movie> searchByTitle(String word);
	
	//하나조회
	public Movie read(int id);
	
	//등록
	public int insert(Movie movie);
	
	//업데이트
	public int update(Movie movie);
	
	//삭제
	public int delete(int id);
	
}
