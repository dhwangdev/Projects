package com.proj.community.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.community.model.dao.UserDao;
import com.proj.community.model.dto.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public User get(String nickname) {
		return userDao.read(nickname);
	}

	@Override
	public boolean checkOverlap(String type, String val) {
		if(type.equals("id")) {
			return userDao.idCheck(val) == 0;
		}
		else if(type.equals("email")) {
			return userDao.emailCheck(val) == 0;
		}
		else {
			return userDao.nicknameCheck(val) == 0;
		}
	}


	@Override
	public boolean add(User user) {
		return userDao.create(user) == 1;
	}

	@Override
	public boolean login(User user) {
		return userDao.login(user) == 1;
	}

	@Override
	public boolean modify(User user) {
		return userDao.update(user) == 1;
	}

	@Override
	public boolean remove(User user) {
		return userDao.delete(user) == 1;
	}

	@Override
	public String getNickname(String userId) {
		return userDao.readNickname(userId);
		
	}
	

}
