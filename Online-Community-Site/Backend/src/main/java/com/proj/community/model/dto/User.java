package com.proj.community.model.dto;

import java.util.Date;

public class User {
	private String userId;
	private String password;
	private String email;
	private String nickname;
	private String image;
	private String joinDate;

	public User(String userId, String password, String email, String nickname, String image, String joinDate) {
		super();
		this.userId = userId;
		this.password = password;
		this.email = email;
		this.nickname = nickname;
		this.image = image;
		this.joinDate = joinDate;
	}

	public User() {
		super();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", email=" + email + ", nickname=" + nickname
				+ ", image=" + image + ", joinDate=" + joinDate + "]";
	}

}
