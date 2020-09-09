package com.example.demo.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.example.demo.dtos.DetalleFacturaDto;
import com.example.demo.entity.DetalleFactura;
import com.example.demo.repository.DetalleFacturaRepository;

@Service
public class DetalleFacturaServicio  {

	DetalleFacturaRepository repository;

	public DetalleFacturaServicio(DetalleFacturaRepository repository) {
		super();
		this.repository = repository;
	}
	
public List<DetalleFacturaDto> findAll() throws Exception {
		
		List<DetalleFactura>entities = repository.findAll();
		List<DetalleFacturaDto>dtos = new ArrayList<DetalleFacturaDto>();
		try {
			
			for(DetalleFactura entity : entities) {
				DetalleFacturaDto dto = new DetalleFacturaDto();
				dto.setId(entity.getId());
				dto.setCantidad(entity.getCantidad());
				dto.setSubtotal(entity.getSubtotal());
				dto.setFactura(entity.getFactura());
				dto.setArticuloConsumo(entity.getArticuloConsumo());
				dto.setArticuloManufacturado(entity.getArticuloManufacturado());
				dtos.add(dto);
			}
			
			return dtos;
			
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
public DetalleFacturaDto findById(int id) throws Exception{
	
	Optional<DetalleFactura>entityOptional = repository.findById((long) id);
	
	DetalleFacturaDto dto = new DetalleFacturaDto();
	
	try {
		 DetalleFactura entity = entityOptional.get();
		
			dto.setId(entity.getId());
			dto.setCantidad(entity.getCantidad());
			dto.setSubtotal(entity.getSubtotal());
			dto.setFactura(entity.getFactura());
			dto.setArticuloConsumo(entity.getArticuloConsumo());
			dto.setArticuloManufacturado(entity.getArticuloManufacturado());
			
	} catch (Exception e) {
		throw new Exception();
	}
	
	return dto;
}

public DetalleFacturaDto save(DetalleFacturaDto dto, boolean estado) throws Exception {
	
	DetalleFactura entity = new DetalleFactura();
	
	entity.setCantidad(dto.getCantidad());
	entity.setSubtotal(dto.getSubtotal());
	entity.setFactura(dto.getFactura());
	entity.setArticuloConsumo(dto.getArticuloConsumo());
	entity.setArticuloManufacturado(dto.getArticuloManufacturado());
	
	
	try {
		entity = repository.save(entity);
		dto.setId(entity.getId());
		return dto;
	} catch (Exception e) {
		throw new Exception();	
	}
	
		
}	
	
public DetalleFacturaDto update(int id, DetalleFacturaDto dto, boolean estado) throws Exception {
	Optional<DetalleFactura> optionalEntity = repository.findById((long) id);
	
	try {
		 DetalleFactura entity = optionalEntity.get();
		    entity.setId(id);
		    entity.setCantidad(dto.getCantidad());
			entity.setSubtotal(dto.getSubtotal());
			entity.setFactura(dto.getFactura());
			entity.setArticuloConsumo(dto.getArticuloConsumo());
			entity.setArticuloManufacturado(dto.getArticuloManufacturado());
		 
		 repository.save(entity);
		 dto.setId(entity.getId());
		 return dto;
		 
	} catch (Exception e) {
		// TODO: handle exception
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

	
}