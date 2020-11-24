package com.example.demo.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.ArticuloDto;
import com.example.demo.dtos.ClienteDto;
import com.example.demo.dtos.DetallePedidoDto;
import com.example.demo.dtos.DomicilioDto;
import com.example.demo.dtos.PedidoDto;
import com.example.demo.entity.Articulo;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.DetallePedido;
import com.example.demo.entity.Domicilio;
import com.example.demo.entity.Pedido;
import com.example.demo.repository.ClienteRepository;

@Service
public class ClienteServicio{
	
	ClienteRepository repository;
	@Autowired (required = true)
	protected DomicilioServicio domService;
	protected PedidoServicio pedService;
	protected DetallePedidoServicio detPedService;

	public ClienteServicio(ClienteRepository repository) {
		this.repository = repository;
	}
	
public List<ClienteDto> findAll() throws Exception {
	
		
		
		List<Cliente>entities = repository.findAll();
		List<ClienteDto>dtos = new ArrayList<ClienteDto>();
		List<PedidoDto> pedidos = new ArrayList<PedidoDto>();
		
		try {
			
			for(Cliente entity : entities) {
				ClienteDto dto = new ClienteDto();
				dto.setId(entity.getId());
				dto.setNombre(entity.getNombre());
				dto.setApellido(entity.getApellido());
				dto.setTelefono(entity.getTelefono());
				dto.setEmail(entity.getEmail());
				
				//////////////////////////////////////////////////////////////////////
				/*
				Domicilio domicilioEntity2 = entity.getDomicilio();
				dto.setDomicilioDto(domService.findById((int)domicilioEntity2.getId()));
				
				for(Pedido entityPedido : entity.getPedidoList()) {
					PedidoDto dtoPedido = new PedidoDto();
					List<DetallePedidoDto> datallePedidos = new ArrayList<DetallePedidoDto>();
					
					dtoPedido=pedService.findById((int)entityPedido.getId());
					
					for(DetallePedido entityDetalle : entityPedido.getDetalles()) {
						DetallePedidoDto dtoDetalle = new DetallePedidoDto();
						
						dtoDetalle=detPedService.findById((int)entityDetalle.getId());					
						
						datallePedidos.add(dtoDetalle);
					}
					dtoPedido.setDetalles(datallePedidos);
					pedidos.add(dtoPedido);
				}
				
				dto.setPedidoListDto(pedidos);
				*/
				
				////////////////////////////////////////////////////////////////////7
				
				
				DomicilioDto domicilioDto = new DomicilioDto();
				Domicilio domicilioEntity = entity.getDomicilio();
				
				if(domicilioEntity != null) {
					domicilioDto.setId(domicilioEntity.getId());
					domicilioDto.setCalle(domicilioEntity.getCalle());
					domicilioDto.setNumero(domicilioEntity.getNumero());
					domicilioDto.setLocalidad(domicilioEntity.getLocalidad());
					domicilioDto.setDepartamento(domicilioEntity.getDepartamento());
				}
				
				
				
				for(Pedido entityPedido : entity.getPedidoList()) {
					PedidoDto dtoPedido = new PedidoDto();
					dtoPedido.setId(entityPedido.getId());
					dtoPedido.setFecha(entityPedido.getFecha());
					dtoPedido.setNumero(entityPedido.getNumero());
					dtoPedido.setEstado(entityPedido.getEstado());
					dtoPedido.setTiempoRequerido(entityPedido.getTiempoRequerido());
					dtoPedido.setFactura(entityPedido.getFactura());
					
					for(DetallePedido entityDetalle : entityPedido.getDetalles()) {
						DetallePedidoDto dtoDetalle = new DetallePedidoDto();
						dtoDetalle.setId(entityDetalle.getId());
						dtoDetalle.setCantidad(entityDetalle.getCantidad());
						dtoDetalle.setSubtotal(entityDetalle.getSubtotal());

						ArticuloDto articuloConsumoDto = new ArticuloDto();   
						Articulo articuloConsumoEntity = entityDetalle.getArticulo();
						articuloConsumoDto.setDenominacion(articuloConsumoEntity.getDenominacion());
						articuloConsumoDto.setPrecioCompra(articuloConsumoEntity.getPrecioCompra());
						articuloConsumoDto.setPrecioVenta(articuloConsumoEntity.getPrecioVenta());
						dtoDetalle.setArticuloDto(articuloConsumoDto);
						
						dtoPedido.getDetalles().add(dtoDetalle);	
					}
				
					
				}
			    dtos.add(dto);
			}
			
			return dtos;
			
		} catch (Exception e) {
			throw new Exception();
		}
	}
	

public ClienteDto findById(int id) throws Exception{
	
	Optional<Cliente>entityOptional = repository.findById((long) id);
	
	ClienteDto dto = new ClienteDto();
	
	try {
		 Cliente entity = entityOptional.get();
		
		 dto.setId(entity.getId());
			dto.setNombre(entity.getNombre());
			dto.setApellido(entity.getApellido());
			dto.setTelefono(entity.getTelefono());
			dto.setEmail(entity.getEmail());
			
			DomicilioDto domicilioDto = new DomicilioDto();
			Domicilio domicilioEntity = entity.getDomicilio();
			if(domicilioEntity != null) {
				domicilioDto.setId(domicilioEntity.getId());
				domicilioDto.setCalle(domicilioEntity.getCalle());
				domicilioDto.setNumero(domicilioEntity.getNumero());
				domicilioDto.setLocalidad(domicilioEntity.getLocalidad());
				domicilioDto.setDepartamento(domicilioEntity.getDepartamento());
				dto.setDomicilioDto(domicilioDto);
			}
			
					
	} catch (Exception e) {
		throw new Exception();
	}
	
	return dto;
}

public ClienteDto save(ClienteDto dto, boolean estado) throws Exception {
	
	Optional<Cliente>entityOptional = repository.findByEmail(dto.getEmail());
	
	if(!entityOptional.isEmpty()) {
	
		Cliente entity = new Cliente();
		
		entity.setNombre(dto.getNombre());
		entity.setApellido(dto.getApellido());
		entity.setTelefono(dto.getTelefono());
		entity.setEmail(dto.getEmail());
		
		Domicilio dom = new Domicilio();			
		dom.setCalle(dto.getDomicilioDto().getCalle());
		dom.setDepartamento(dto.getDomicilioDto().getDepartamento());
		dom.setLocalidad(dto.getDomicilioDto().getLocalidad());
		dom.setNumero(dto.getDomicilioDto().getNumero());
		
		entity.setDomicilio(dom);
		
		
		try {
			entity = repository.save(entity);
			dto.setId(entity.getId());
			return dto;
		} catch (Exception e) {
			throw new Exception();	
		}
		
	}else {
		System.out.println("El cliente que quiere guardar tiene un email ya existente en la Base de datos");
		return dto;
	}
	
		
}

public ClienteDto update(int id, ClienteDto dto, boolean estado) throws Exception {
	Optional<Cliente> optionalEntity = repository.findById((long) id);
	
	try {
		 Cliente entity = optionalEntity.get();
		    entity.setId(id);
		    entity.setNombre(dto.getNombre());
			entity.setApellido(dto.getApellido());
			entity.setTelefono(dto.getTelefono());
			entity.setEmail(dto.getEmail());
			
			
			if(dto.getDomicilioDto().getId() > 0) {
				Domicilio dom = new Domicilio();
				dom = this.domService.getDomicilioEntityById(dto.getDomicilioDto().getId());
				
				if(dom != null) {
					dom.setCalle(dto.getDomicilioDto().getCalle());
					dom.setDepartamento(dto.getDomicilioDto().getDepartamento());
					dom.setLocalidad(dto.getDomicilioDto().getLocalidad());
					dom.setNumero(dto.getDomicilioDto().getNumero());
					
					this.domService.saveDomEntity(dom);
				}
			}else {
				Domicilio dom = new Domicilio();			
				dom.setCalle(dto.getDomicilioDto().getCalle());
				dom.setDepartamento(dto.getDomicilioDto().getDepartamento());
				dom.setLocalidad(dto.getDomicilioDto().getLocalidad());
				dom.setNumero(dto.getDomicilioDto().getNumero());
				
				entity.setDomicilio(dom);
			}			
		 
		 repository.save(entity);
		 dto.setId(entity.getId());
		 return dto;
		 
	} catch (Exception e) {
		System.out.println("Error en ClienteServicio update" + e.getMessage());
	}
	return dto;
}
		
public boolean delete(int id) throws Exception {
	try {
		if(repository.existsById((long) id)) {
			repository.deleteById((long) id);
			return true;
		}else {
			throw new Exception();
		}
	} catch (Exception e) {
		throw new Exception();
	}
}

public int countPages(int size) throws Exception {
	try {
		Pageable pageable = PageRequest.of(0, size);
		return repository.findAll(pageable).getTotalPages();			

	} catch (Exception e) {
		throw new Exception(e.getMessage());
	}
}

public ClienteDto findByEmail(String email) throws Exception {
	Optional<Cliente>entityOptional = repository.findByEmail(email);
	
	ClienteDto dto = new ClienteDto();
	
	try {
		Cliente entity = entityOptional.get();
		
		if(entity != null) {
			dto.setId(entity.getId());
			dto.setNombre(entity.getNombre());
			dto.setApellido(entity.getApellido());
			dto.setTelefono(entity.getTelefono());
			dto.setEmail(entity.getEmail());
			
			DomicilioDto domicilioDto = new DomicilioDto();
			Domicilio domicilioEntity = entity.getDomicilio();
			if(domicilioEntity != null) {
				domicilioDto.setId(domicilioEntity.getId());
				domicilioDto.setCalle(domicilioEntity.getCalle());
				domicilioDto.setNumero(domicilioEntity.getNumero());
				domicilioDto.setLocalidad(domicilioEntity.getLocalidad());
				domicilioDto.setDepartamento(domicilioEntity.getDepartamento());
				
				dto.setDomicilioDto(domicilioDto);
			}		
		}		
					
	} catch (Exception e) {
		throw new Exception();
	}
	
	return dto;
}
}
