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

import com.proj.community.model.dto.Article;
import com.proj.community.model.service.ArticleService;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RequestMapping("/article")
@RestController
public class ArticleRestController {
	

	private static final Logger logger = LoggerFactory.getLogger(ArticleRestController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	ArticleService articleService;
	
	//검색
	@GetMapping("/search/{category}/{searchTarget}/{word}")
	public ResponseEntity<List<Article>> searchArticle(@PathVariable String category, @PathVariable String searchTarget, @PathVariable String word) {
		logger.debug("searchArticle - 호출");
		return new ResponseEntity<List<Article>>(articleService.search(category, searchTarget, word), HttpStatus.OK);
	}
	//카테고리조회
	@GetMapping("/search/{category}/{sortTarget}")
	public ResponseEntity<List<Article>> getListArticleCategory(@PathVariable String category, @PathVariable String sortTarget) {
		logger.debug("getListArticleCategory - 호출");
		return new ResponseEntity<List<Article>>(articleService.getCategory(category, sortTarget), HttpStatus.OK);
	}
	//전체조회
	@GetMapping
	public ResponseEntity<List<Article>> getListArticle() {
		logger.debug("getListArticle - 호출");
		return new ResponseEntity<List<Article>>(articleService.getList(), HttpStatus.OK);
	}

	//작성자 게시글 리스트 조회
	@GetMapping("/search/{writer}")
	public ResponseEntity<List<Article>> getListByWriter(@PathVariable String writer) {
		logger.debug("getListByWriter - 호출");
		return new ResponseEntity<List<Article>>(articleService.searchByWriter(writer), HttpStatus.OK);
	}
	
	//아이디로 조회
	@GetMapping("/{id}")
	public ResponseEntity<Article> getArticle(@PathVariable int id) {
		logger.debug("getArticle - 호출");
		return new ResponseEntity<Article>(articleService.get(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> insertArticle(@RequestBody Article article) {
		logger.debug("insertArticle - 호출");
		if (articleService.add(article)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@PutMapping
	public ResponseEntity<String> modifyArticle(@RequestBody Article article) {
		logger.debug("modifyArticle - 호출");
		System.out.println("asdfasfsaf");
		System.out.println(article);
		if (articleService.modify(article)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removeArticle(@PathVariable int id) {
		logger.debug("removeArticle - 호출");
		if (articleService.remove(id)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
}
