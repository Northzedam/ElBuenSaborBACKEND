package com.example.demo.dtos;

public class UserDto {
	
	private long id;
	
	private String uid;
	
	private String email;
	
	private String role;
	

	public UserDto() {
		super();
	}

	

	public UserDto(long id, String uid, String email, String role) {
		super();
		this.id = id;
		this.uid = uid;
		this.email = email;
		this.role = role;
	}

	

	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
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
