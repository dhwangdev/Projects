package com.proj.community.model.dao;

import java.util.List;

import com.proj.community.model.dto.Recipe;

public interface RecipeDao {
	
	//검색O ->추천순
	public List<Recipe> SearchByTitle(String word);
	
	//전체조회(추천순)
	public List<Recipe> readAll();
	
	//하나조회
	public Recipe read(int id);
	
	public int create(Recipe recipe);
	
	public int update(Recipe recipe);
	
	public int delete(int id);
}
