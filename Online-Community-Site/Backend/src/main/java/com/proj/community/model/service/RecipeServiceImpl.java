package com.proj.community.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.community.model.dao.RecipeDao;
import com.proj.community.model.dto.Recipe;

@Service
public class RecipeServiceImpl implements RecipeService{

	@Autowired
	private RecipeDao recipeDao;

	@Override
	public List<Recipe> getListByTitle(String word) {
		return recipeDao.SearchByTitle(word);
	}

	@Override
	public List<Recipe> getAll() {
		return recipeDao.readAll();
	}

	@Override
	public Recipe get(int id) {
		return recipeDao.read(id);
	}

	@Override
	public boolean add(Recipe recipe) {
		return recipeDao.create(recipe) == 1;
	}

	@Override
	public boolean modify(Recipe recipe) {
		return recipeDao.update(recipe) == 1;
	}

	@Override
	public boolean remove(int id) {
		return recipeDao.delete(id) == 1;
	}

	@Override
	public void getData(List<Recipe> recipeList) {
		for (int i = 0; i < recipeList.size(); i++) {
			recipeDao.create(recipeList.get(i));
		}
		
	}
	

	
	
}
