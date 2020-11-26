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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.ParametrosDto;
import com.example.demo.dtos.ReporteMasVendidosDto;
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
			public ResponseEntity getAll(@RequestParam String fechaDesdeHasta){
				try {
					//return ResponseEntity.status(HttpStatus.OK).body(service.findArticulosMasVendidos(fechaDesde, fechaHasta));
					return ResponseEntity.status(HttpStatus.OK).body(service.findArticulosMasVendidos(fechaDesdeHasta));

					
				}catch(Exception e) {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Mi mensaje get todos\": \"" + e.getMessage() + "\"}");
				}
			}
			
			@GetMapping("/ganancias")
			@Transactional
			public ResponseEntity getGananciasPorFecha(@RequestParam String fechaDesdeHasta){
				try {
					//return ResponseEntity.status(HttpStatus.OK).body(service.findArticulosMasVendidos(fechaDesde, fechaHasta));
					return ResponseEntity.status(HttpStatus.OK).body(service.findGanancias(fechaDesdeHasta));

					
				}catch(Exception e) {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Mi mensaje get todos\": \"" + e.getMessage() + "\"}");
				}
			}
			
			@GetMapping("/pedidosPorCliente")
			@Transactional
			public ResponseEntity getPedidosPorCliente(@RequestParam String fechaDesdeHasta){
				try {
					//return ResponseEntity.status(HttpStatus.OK).body(service.findArticulosMasVendidos(fechaDesde, fechaHasta));
					return ResponseEntity.status(HttpStatus.OK).body(service.findPedidosPorCliente(fechaDesdeHasta));

					
				}catch(Exception e) {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Mi mensaje get todos\": \"" + e.getMessage() + "\"}");
				}
			}
		
			@GetMapping("/insumosStockMinimo")
			@Transactional
			public ResponseEntity getInsumosDebajoDeStockMinimo(){
				try {
					//return ResponseEntity.status(HttpStatus.OK).body(service.findArticulosMasVendidos(fechaDesde, fechaHasta));
					return ResponseEntity.status(HttpStatus.OK).body(service.findInsumosDebajoDeStockMinimo());

					
				}catch(Exception e) {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Mi mensaje get todos\": \"" + e.getMessage() + "\"}");
				}
			}
			

}
