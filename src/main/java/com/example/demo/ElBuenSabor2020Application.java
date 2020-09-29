package com.example.demo;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationHome;

@SpringBootApplication
public class ElBuenSabor2020Application {
	
	private static File home;

	public static void main(String[] args) {
		SpringApplication.run(ElBuenSabor2020Application.class, args);
	}

	public static File getHome() {
		ApplicationHome home = new ApplicationHome(ElBuenSabor2020Application.class);
		return home.getSource();
	}
}
