package com.proj.community.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
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

import com.proj.community.model.dto.User;
import com.proj.community.model.service.UserService;
import com.proj.community.util.JwtUtil;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RequestMapping("/user")
@RestController
public class UserRestController {

	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private UserService userService;

	private static final Logger logger = LoggerFactory.getLogger(UserRestController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	//로그인
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody User user) {
		logger.debug("login - 호출");
		HashMap<String, Object> result = new HashMap<>();
		HttpStatus status = null;
		try {
			if (userService.login(user)) {
				result.put("nickname", userService.getNickname(user.getUserId()));
				result.put("access-token", jwtUtil.createToken("id", user.getUserId()));
				result.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} else {
				result.put("message", FAIL);
				status = HttpStatus.ACCEPTED;
			}
		} catch (UnsupportedEncodingException e) {
			result.put("message", FAIL);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(result, status);
	}
	
	//회원등록
	@PostMapping("/regist")
	public ResponseEntity<String> registUser(@RequestBody User user) {
		logger.debug("registUser - 호출");
		if (userService.add(user)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	//중복체크, 아이디, 닉네임, 이메일
	@GetMapping("/check/{type}/{val}")
	public ResponseEntity<String> overlapCheck(@PathVariable String type, @PathVariable String val){
		logger.debug("overlapCheck - 호출");
		if (userService.checkOverlap(type, val)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}
	
	//회원 삭제 axios바디에 데이터 넣어서 보내줘야됨
	@DeleteMapping("/delete")
	public ResponseEntity<String> removeUser(@RequestBody User user){
		logger.debug("removeUser - 호출");
		if (userService.remove(user)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	//회원정보 반환(닉네임으로) - 비밀번호 확인 할 것
	@GetMapping("/search/{nickname}")
	public ResponseEntity<User> getUserInfo(@PathVariable String nickname){
		logger.debug("getUserInfo - 호출");
		return new ResponseEntity<User>(userService.get(nickname), HttpStatus.OK);
	}
	
	//회원정보 변경
	@PutMapping("/update")
	public ResponseEntity<String> modifyUser(@RequestBody User user){
		logger.debug("modifyUser - 호출");
		if (userService.modify(user)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
}
