package com.proj.community.model.service;

import java.util.List;

import com.proj.community.model.dto.Movie;

public interface MovieService {
	//전체 조회(추천순 정렬해서 보내준다.)
	public List<Movie> SearchByTitle(String word);
	
	public List<Movie> getList();
	
	//하나조회
	public Movie get(int id);
	
	//등록
	public boolean add(Movie movie);
	
	//업데이트
	public boolean modify(Movie movie);
	
	//삭제
	public boolean remove(int id);
	
	//api데이터 받기
	public void getData(List<Movie> movieList);
}
