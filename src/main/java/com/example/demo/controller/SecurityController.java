package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {
	
	@GetMapping({"/","/login"})
	public String index() {
		
		return "index";
	}

	@GetMapping({"/user"})
	public String user() {
		
		return "user";
	}
	
	@GetMapping({"/admin"})
	public String admin() {
		
		return "admin";
	}
}
