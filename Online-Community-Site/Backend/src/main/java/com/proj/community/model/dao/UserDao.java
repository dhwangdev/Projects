package com.proj.community.model.dao;

import com.proj.community.model.dto.User;

public interface UserDao {
	
	//닉네임로조회
	public User read(String nickname);
	
	//id로조회
	public String readNickname(String userId);
	
	//닉네임중복확인
	public int nicknameCheck(String nickname);
	
	//id중복확인
	public int idCheck(String id);
	
	//이메일중복확인
	public int emailCheck(String email);
	
	//등록
	public int create(User user);
	
	//업데이트
	public int update(User user);
	
	//회원탈퇴
	public int delete(User user);
	
	//로그인
	public int login(User user);
	
	//회원찾기(보류)
}
