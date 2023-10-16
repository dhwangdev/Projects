package com.proj.community.model.dao;

import java.util.List;

import com.proj.community.model.dto.Sport;

public interface SportDao {
	//검색O(제목) 조회수, 추천수 정렬
	//default 추천수, view : 조회수, ASC, DESC
	public List<Sport> readCategory(String category, String target, String direction);
	public List<Sport> search(String word);

	public Sport read(int id);
	
	public int create(Sport sport);
	
	public int update(Sport sport);
	
	public int delete(int id);
}
