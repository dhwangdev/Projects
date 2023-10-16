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

import com.proj.community.model.dto.Book;
import com.proj.community.model.service.BookService;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RequestMapping("/book")
@RestController
public class BookRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(BookRestController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/category/{category}")
	public ResponseEntity<List<Book>> searchByCategory(@PathVariable String category) {
		logger.debug("searchByCategory - 호출");
		return new ResponseEntity<List<Book>>(bookService.getListByCategory(category), HttpStatus.OK);
	}
	
	@GetMapping("/search/{word}")
	public ResponseEntity<List<Book>> searchByType(@PathVariable String word) {
		logger.debug("searchByType - 호출");
		return new ResponseEntity<List<Book>>(bookService.search(word), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Book> searchBook(@PathVariable int id) {
		logger.debug("searchBook - 호출");
		return new ResponseEntity<Book>(bookService.get(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> insertBook(@RequestBody Book book) {
		logger.debug("insertBook - 호출");
		if (bookService.add(book)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@PutMapping
	public ResponseEntity<String> modifyBook(@RequestBody Book book) {
		logger.debug("modifyBook - 호출");
		if (bookService.modify(book)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removeBook(@PathVariable int id) {
		logger.debug("removeBook - 호출");
		if (bookService.remove(id)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/api")
	public ResponseEntity<String> getApiData(@RequestBody List<Book> bookList) {
		logger.debug("getApiData - 호출");
		if (bookList.size() > 0) {
			bookService.getData(bookList);
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
}
