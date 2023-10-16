package com.proj.community.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proj.community.model.dto.Recipe;
import com.proj.community.model.service.RecipeService;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RequestMapping("/recipe")
@RestController
public class RecipeRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(RecipeRestController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	RecipeService recipeService;
	
	@GetMapping("/search/{word}")
	public ResponseEntity<List<Recipe>> searchByTitle(@PathVariable String word) {
		logger.debug("searchByTitle - 호출");
		return new ResponseEntity<List<Recipe>>(recipeService.getListByTitle(word), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Recipe>> searchList() {
		logger.debug("searchList - 호출");
		return new ResponseEntity<List<Recipe>>(recipeService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Recipe> searchRecipe(@PathVariable int id) {
		logger.debug("searchRecipe - 호출");
		return new ResponseEntity<Recipe>(recipeService.get(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> insertRecipe(@RequestBody Recipe recipe) {
		logger.debug("insertRecipe - 호출");
		if (recipeService.add(recipe)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@PutMapping
	public ResponseEntity<String> modifyRecipe(@RequestBody Recipe recipe) {
		logger.debug("modifyRecipe - 호출");
		if (recipeService.modify(recipe)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removeRecipe(@PathVariable int id) {
		logger.debug("removeRecipe - 호출");
		if (recipeService.remove(id)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/api")
	public ResponseEntity<String> getApiData(@RequestBody List<Recipe> recipeList) {
		logger.debug("getApiData - 호출");
		if (recipeList.size() > 0) {
			recipeService.getData(recipeList);
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

}
