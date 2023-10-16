package com.proj.community.model.service;

import com.proj.community.model.dto.User;

public interface UserService {
	//id로조회
	public User get(String nickname);
	
	//중복체크
	public boolean checkOverlap(String type, String val);
	
	//회원등록
	public boolean add(User user);
	
	//로그인
	public boolean login(User user);
	
	//회원정보수정
	public boolean modify(User user);
	
	//회원삭제
	public boolean remove(User user);
	//
	public String getNickname(String userId);
	//회원찾기 (보류)
}
