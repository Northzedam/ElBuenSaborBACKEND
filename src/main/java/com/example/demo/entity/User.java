package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;

@Column
private String uid;

@Column
private String role;

@Column
private String email;

public User() {
	super();
}

public User(Long id, String uid, String role, String email) {
	super();
	this.id = id;
	this.uid = uid;
	this.role = role;
	this.email = email;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getUid() {
	return uid;
}

public void setUid(String uid) {
	this.uid = uid;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}




}