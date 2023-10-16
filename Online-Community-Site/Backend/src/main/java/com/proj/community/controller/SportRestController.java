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

import com.proj.community.model.dto.Sport;
import com.proj.community.model.service.SportService;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RequestMapping("/sport")
@RestController
public class SportRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(SportRestController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	SportService sportService;

	@GetMapping("/search/{word}")
	public ResponseEntity<List<Sport>> search(@PathVariable String word) {
		logger.debug("searchByTitle - 호출");
		return new ResponseEntity<List<Sport>>(sportService.searchByTitle(word), HttpStatus.OK);
	}
	
	@GetMapping("/category/{category}/{target}/{direction}")
	public ResponseEntity<List<Sport>> searchByCategory(@PathVariable String category, @PathVariable String target, @PathVariable String direction) {
		logger.debug("searchByCategory - 호출");
		return new ResponseEntity<List<Sport>>(sportService.getByCategory(category, target, direction), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Sport> searchSport(@PathVariable int id) {
		logger.debug("searchSport - 호출");
		return new ResponseEntity<Sport>(sportService.get(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> insertSport(@RequestBody Sport sport) {
		logger.debug("insertSport - 호출");
		if (sportService.add(sport)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@PutMapping
	public ResponseEntity<String> modifySport(@RequestBody Sport sport) {
		logger.debug("modifySport - 호출");
		if (sportService.modify(sport)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removeSport(@PathVariable int id) {
		logger.debug("removeSport - 호출");
		if (sportService.remove(id)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
}
