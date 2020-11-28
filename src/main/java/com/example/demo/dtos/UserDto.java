package com.example.demo.dtos;

public class UserDto {
	
	private String uid;
	
	private String email;
	
	private String role;
	

	public UserDto() {
		super();
	}

	public UserDto(String uid, String email, String role) {
		super();
		this.uid = uid;
		this.email = email;
		this.role = role;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	

}
