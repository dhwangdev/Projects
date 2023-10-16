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

import com.proj.community.model.dto.Movie;
import com.proj.community.model.service.MovieService;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RequestMapping("/movie")
@RestController
public class MovieRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(MovieRestController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	MovieService movieService;
	
	@GetMapping("/search/{word}")
	public ResponseEntity<List<Movie>> searchByTitle(@PathVariable String word) {
		logger.debug("searchListMovie - 호출");
		return new ResponseEntity<List<Movie>>(movieService.SearchByTitle(word), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Movie>> searchListMovie() {
		logger.debug("searchListMovie - 호출");
		return new ResponseEntity<List<Movie>>(movieService.getList(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Movie> searchMovie(@PathVariable int id) {
		logger.debug("searchMovie - 호출");
		return new ResponseEntity<Movie>(movieService.get(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> insertMovie(@RequestBody Movie movie) {
		logger.debug("insertMovie - 호출");
		if (movieService.add(movie)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@PutMapping
	public ResponseEntity<String> modifyMovie(@RequestBody Movie movie) {
		logger.debug("modifyMovie - 호출");
		logger.debug("" + movie);
		if (movieService.modify(movie)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removeMovie(@PathVariable int id) {
		logger.debug("removeMovie - 호출");
		logger.debug("" + id);
		System.out.println(id);
		if (movieService.remove(id)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/api")
	public ResponseEntity<String> getApiData(@RequestBody List<Movie> movieList) {
		logger.debug("getApiData - 호출");
		if (movieList.size() > 0) {
			movieService.getData(movieList);
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

}
