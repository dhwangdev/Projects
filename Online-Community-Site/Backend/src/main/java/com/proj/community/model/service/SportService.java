package com.proj.community.model.service;

import java.util.List;

import com.proj.community.model.dto.Sport;

public interface SportService {
	//검색O(제목) 조회수, 추천수 정렬
	//default 추천수, view : 조회수, ASC, DESC
	public List<Sport> searchByTitle(String word);
	public List<Sport> getByCategory(String category, String target, String direction);
	
	public Sport get(int id);
	
	public boolean add(Sport sport);
	
	public boolean modify(Sport sport);
	
	public boolean remove(int id);
}
