package com.example.demo.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dtos.ArticuloConsumoDto;
import com.example.demo.entity.ArticuloConsumo;
import com.example.demo.service.ArticuloConsumoServicio;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
@RequestMapping(path = "api/v1/articuloConsumo")
public class ArticuloConsumoController{
	
	@Autowired (required = true)
	protected ArticuloConsumoServicio service;
	
	//getAll-----------------------
	
	@GetMapping("/")
	@Transactional
	public ResponseEntity getAll (){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Mi mensaje get todos\": \"" + e.getMessage() + "\"}");
		}
	}
	
	//getOne-----------------------
	
	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity getOne(@PathVariable int id) {

		try {

			return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"Mi mensaje get uno\": \"" + e.getMessage() + "\"}");

		}

	}
	
	
	//post-----------------------
	
	@PostMapping("/")

	@Transactional
	public ResponseEntity post(@RequestBody ArticuloConsumoDto dto) {
		
		try {
			

			return ResponseEntity.status(HttpStatus.OK).body(service.save(dto, true));
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body
		("{\"message\": \"Error. Please check the BODY request, and try again later.\"}");
						
		}
		
	}
	
	@PostMapping(value = "/saveImage")
	
	@Transactional	
	public ResponseEntity postImage(@RequestParam("imagen") MultipartFile imagen) {
	
		if(imagen.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body("Seleccione un archivo");				
		}
		
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.saveImage(imagen));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body
					("{\"message\":\"Error.Please check the BODY request, and try again.\"}");
		}
	}
	
	
	@PutMapping("/{id}")

	@Transactional
	public ResponseEntity put(@PathVariable int id, @RequestBody ArticuloConsumoDto dto) {
		
		try {
			
			
			return ResponseEntity.status(HttpStatus.OK).body(service.update(id, dto, true));
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body
					("{\"message\": \"Error. Please check the ID or BODY request, and try again later.\"}");
						
		}
		
	}
	//delete-----------------------
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity delete(@PathVariable int id) {

		try {

			return ResponseEntity.status(HttpStatus.OK).body(service.delete(id));

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("{\"Mi mensaje put\": \"" + e.getMessage() + "\"}");
		}

	}
	
	//getCount-----------------------
	
	@GetMapping("/count")
	@Transactional
	public ResponseEntity getCount(@RequestParam(value =  "size", defaultValue = "10") int size) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body("{\"pages\": "+service.countPages(size)+"}");
		} catch (Exception e) {
			return null;
		}
		
	}

}