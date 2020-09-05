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

import com.example.demo.dtos.ArticuloConsumoDto;
import com.example.demo.entity.RubroArticulo;
import com.example.demo.service.RubroArticuloServicio;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
@RequestMapping(path = "api/v1/rubroArticulo")
public class RubroArticuloController{
	
	@Autowired (required = true)
	protected RubroArticuloServicio service;
	
	//getAll-----------------------
	
	@GetMapping("/")
	@Transactional
	public ResponseEntity<?> getAll (@RequestParam(value="page",defaultValue = "0") int page, @RequestParam(value="size", defaultValue = "10") int size){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findAll(page, size));
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Mi mensaje get todos\": \"" + e.getMessage() + "\"}");
		}
	}
	
	//getOne-----------------------
	
	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity<?> getOne(@PathVariable int id) {

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
	public ResponseEntity<?> post(@RequestBody RubroArticuloDto dto) {

		try {

			return ResponseEntity.status(HttpStatus.CREATED).body(service.save(personaForm));

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("{\"Mi mensaje post\": \"" + e.getMessage() + "\"}");

		}

	}
	
	//put-----------------------
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<?> put(@PathVariable int id, @RequestBody RubroArticuloDto dto) {

		try {

			return ResponseEntity.status(HttpStatus.OK).body(service.update(id, personaForm));

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("{\"Mi mensaje put\": \"" + e.getMessage() + "\"}");
		}

	}
	
	//delete-----------------------
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> delete(@PathVariable int id) {

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
	public ResponseEntity<?> getCount(@RequestParam(value =  "size", defaultValue = "10") int size) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body("{\"pages\": "+service.countPages(size)+"}");
		} catch (Exception e) {
			return null;
		}
		
	}

}