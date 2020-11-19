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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.ParametrosDto;
import com.example.demo.service.ParametrosServicio;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
@RequestMapping(path = "api/v1/parametros")
public class ParametrosController {
	
	@Autowired (required = true)
	protected ParametrosServicio service;
	
	
	//getAll-----------------------
	
		@GetMapping("/")
		@Transactional
		public ResponseEntity getAll(){
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
		public ResponseEntity post(@RequestBody ParametrosDto dto) {

			try {

				return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto, true));

			} catch (Exception e) {

				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("{\"Mi mensaje post\": \"" + e.getMessage() + "\"}");

			}

		}
		
		//put-----------------------
		
		@PutMapping("/{id}")
		@Transactional
		public ResponseEntity put(@PathVariable int id, @RequestBody ParametrosDto dto) {

			try {

				return ResponseEntity.status(HttpStatus.OK).body(service.update(id, dto, true));

			} catch (Exception e) {

				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("{\"Mi mensaje put\": \"" + e.getMessage() + "\"}");
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

}
