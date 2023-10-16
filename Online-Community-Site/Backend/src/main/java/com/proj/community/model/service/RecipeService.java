package com.proj.community.model.service;

import java.util.List;

import com.proj.community.model.dto.Recipe;

public interface RecipeService {
	
	//검색O ->추천순
	public List<Recipe> getListByTitle(String word);
	
	public List<Recipe> getAll();
	//하나조회
	public Recipe get(int id);
	
	public boolean add(Recipe recipe);
	
	public boolean modify(Recipe recipe);
	
	public boolean remove(int id);
	
	public void getData(List<Recipe> recipeList);
}
