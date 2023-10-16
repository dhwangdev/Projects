package com.proj.community.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.proj.community.model.dto.Comment;
import com.proj.community.model.dto.Recomment;
import com.proj.community.model.service.CommentService;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RequestMapping("/comment")
@RestController
public class CommentRestController {

	private static final Logger logger = LoggerFactory.getLogger(CommentRestController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	CommentService CommentService;

	// 해당 게시글의 댓글 리스트를 불러온다.
	@GetMapping("/{category}/{articleId}")
	public ResponseEntity<List<Comment>> getCommentList(@PathVariable String category, @PathVariable int articleId) {
		logger.debug("getCommentList - 호출");
		Map<String, Object> map = new HashMap<>();
		map.put("category", category);
		map.put("articleId", articleId);
		return new ResponseEntity<List<Comment>>(CommentService.getComment(map), HttpStatus.OK);
	}

	// 해당 게시글의 대댓글 리스트를 불러온다.
	@GetMapping("{commentId}")
	public ResponseEntity<List<Recomment>> getRecommentList(@PathVariable int commentId) {
		logger.debug("getRecommentList - 호출");
		return new ResponseEntity<List<Recomment>>(CommentService.getRecomment(commentId), HttpStatus.OK);
	}

	// 해당 유저의 댓글 리스트를 불러온다.
	@GetMapping("/search/{nickname}")
	public ResponseEntity<List<Comment>> getByNickname(@PathVariable String nickname) {
		logger.debug("getByNickname - 호출");
		return new ResponseEntity<List<Comment>>(CommentService.searchByWriter(nickname), HttpStatus.OK);
	}

	// Best댓글 3개 불러온다(추천순)
	@GetMapping("/best/{category}/{articleId}")
	public ResponseEntity<List<Comment>> getBestComment(@PathVariable String category, @PathVariable int articleId) {
		logger.debug("getBestComment - 호출");
		Map<String, Object> map = new HashMap<>();
		map.put("category", category);
		map.put("articleId", articleId);
		return new ResponseEntity<List<Comment>>(CommentService.getBest(map), HttpStatus.OK);
	}

	// 댓글 추가한다.
	@PostMapping("/co")
	public ResponseEntity<String> insertComment(@RequestBody Comment comment) {
		logger.debug("insertComment - 호출");
		if (CommentService.addComment(comment)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	// 댓글 수정한다.
	@PutMapping("/co")
	public ResponseEntity<String> modifyComment(@RequestBody Comment comment) {
		logger.debug("modifyComment - 호출");
		if (CommentService.modifyComment(comment)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	// 댓글 삭제한다.
	@DeleteMapping("/co/{commentId}")
	public ResponseEntity<String> removeComment(@PathVariable int commentId) {
		logger.debug("removeComment - 호출");
		if (CommentService.removeComment(commentId)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	// 대댓글 추가한다.
	@PostMapping("/re")
	public ResponseEntity<String> insertRecomment(@RequestBody Recomment recomment) {
		logger.debug("insertRecomment - 호출");
		if (CommentService.addRecomment(recomment)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	// 대댓글 수정한다.
	@PutMapping("/re")
	public ResponseEntity<String> modifyRecomment(@RequestBody Recomment recomment) {
		logger.debug("modifyRecomment - 호출");
		if (CommentService.modifyRecomment(recomment)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	// 대댓글 삭제한다.
	@DeleteMapping("/re/{recommentId}")
	public ResponseEntity<String> removeRecomment(@PathVariable int recommentId) {
		logger.debug("removeRecomment - 호출");
		if (CommentService.removeRecomment(recommentId)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
}
