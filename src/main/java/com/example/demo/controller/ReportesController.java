package com.example.demo.controller;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.ParametrosDto;
import com.example.demo.service.ReportesServicio;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
@RequestMapping(path = "api/v1/reportes")
public class ReportesController {
	
		
		
		@Autowired (required = true)
		protected ReportesServicio service;
		
		
		//getAll-----------------------
		
			@GetMapping("/")
			@Transactional
			public ResponseEntity getAll(@RequestBody Date fechaDesde,@RequestBody Date fechaHasta){
				try {
					//return ResponseEntity.status(HttpStatus.OK).body(service.findArticulosMasVendidos(fechaDesde, fechaHasta));
					return ResponseEntity.status(HttpStatus.OK).body(service.findArticulosMasVendidos(fechaDesde, fechaHasta));

					
				}catch(Exception e) {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Mi mensaje get todos\": \"" + e.getMessage() + "\"}");
				}
			}
			
			//getOne-----------------------
			
		

}
