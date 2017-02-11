package com.gayan.spring.domain;

import java.util.Date;

public class User {
	private int userId;
	private String userName;
	private String email;
	private String supervisorId;
	private String password;
	private String confirmPassword;
	private String title;
	private Boolean enable;
	private Date dob;
	private Date startDate;
	private Date endDate;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
