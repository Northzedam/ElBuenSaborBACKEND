package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

import com.example.demo.dtos.ArticuloDto;
import com.example.demo.dtos.PedidoDto;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.Pedido;
import com.example.demo.service.ClienteServicio;
import com.example.demo.service.PedidoServicio;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
@RequestMapping(path = "api/v1/pedido")
public class PedidoController {
	
	@Autowired (required = true)
	protected PedidoServicio service;
	
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
	
	@GetMapping("/pedidoPorEstadoPedido/{idEstadoPedido}")
	@Transactional
	public ResponseEntity getByIdEstadoPedido(@PathVariable int idEstadoPedido){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findByIdEstadoPedido(idEstadoPedido));
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Mi mensaje get todos\": \"" + e.getMessage() + "\"}");
		}
	}
	
	@GetMapping("/pedidosPorEstado/{status}")
	@Transactional
	public ResponseEntity getPedidosByStatus(@PathVariable String status){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findPedidosByStatus(status));
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Mi mensaje get todos\": \"" + e.getMessage() + "\"}");
		}
	}
	
	@GetMapping("/pedidosNoFinalizados/")
	@Transactional
	public ResponseEntity getPedidosNoFinalizados(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findPedidosNoFinalizados());
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Mi mensaje get todos\": \"" + e.getMessage() + "\"}");
		}
	}
	
	
	@GetMapping("/pedidosPorCliente/{idCliente}")
	@Transactional
	public ResponseEntity getByClienteId(@PathVariable int idCliente){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findPedidosByClienteId(idCliente));
			
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
	public ResponseEntity post(@RequestBody PedidoDto dto) {

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
	public ResponseEntity put(@PathVariable int id, @RequestBody PedidoDto dto) {
		System.out.println("Acá está el comienzo del put");
		try {
			System.out.println("Acá está el try del put");
			return ResponseEntity.status(HttpStatus.OK).body(service.update(id, dto, true));

		} catch (Exception e) {
			System.out.println("Acá está el catch del put");
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
	
	//Paginator
	@GetMapping("/lista/pedidosPaged")
	@Transactional
	public ResponseEntity<Page<Pedido>> pedidos(
		@RequestParam(defaultValue = "0") int page,
		@RequestParam(defaultValue = "10") int size,
		@RequestParam(defaultValue = "fecha") String order,
		@RequestParam(defaultValue = "true") boolean asc,
		@RequestParam(defaultValue = "") String frase,
		@RequestParam(defaultValue = "2000-01-01 00:00:00") String fechaDesde,
		@RequestParam(defaultValue = "2040-12-31 23:59:59") String fechaHasta,
		@RequestParam(defaultValue = "false") boolean usarParamConEnvio,
		@RequestParam(defaultValue = "false") boolean conEnvio,
		@RequestParam(defaultValue = "0") long idEstadoPedido,
		@RequestParam(defaultValue = "false") boolean esFacturado,
		@RequestParam(defaultValue = "false") boolean tieneFechaAnulado,
		@RequestParam(defaultValue = "0") long idCliente
		) throws Exception{
		
		System.out.println("HOLA PEBETE: "+idEstadoPedido);
		
		Date dateFechaDesde = new Date();
		Date dateFechaHasta = new Date();
		
		dateFechaDesde = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fechaDesde);
		dateFechaHasta = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fechaHasta);			
			        
		if(!asc) {
			Page<PedidoDto> pedidos = service.findByFrase(usarParamConEnvio, conEnvio, idEstadoPedido, frase, 
					dateFechaDesde, dateFechaHasta, esFacturado, tieneFechaAnulado, idCliente,
					  PageRequest.of(page, size, Sort.by(order).descending()));
			return new ResponseEntity(pedidos, HttpStatus.OK);
		}else {
			Page<PedidoDto> pedidos = service.findByFrase(usarParamConEnvio, conEnvio, idEstadoPedido, frase, 
					dateFechaDesde, dateFechaHasta, esFacturado, tieneFechaAnulado, idCliente,
					  PageRequest.of(page, size, Sort.by(order)));
			return new ResponseEntity(pedidos, HttpStatus.OK);
		}
	}
}