package com.example.demo.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.DetallePedidoDto;
import com.example.demo.entity.DetallePedido;
import com.example.demo.repository.DetallePedidoRepository;

@Service
public class DetallePedidoServicio{
	
	DetallePedidoRepository repository;

	public DetallePedidoServicio(DetallePedidoRepository repository) {
		this.repository = repository;
	}
	
public List<DetallePedidoDto> findAll() throws Exception {
		
		List<DetallePedido>entities = repository.findAll();
		List<DetallePedidoDto>dtos = new ArrayList<DetallePedidoDto>();
		try {
			
			for(DetallePedido entity : entities) {
				DetallePedidoDto dto = new DetallePedidoDto();
				dto.setId(entity.getId());
				dto.setCantidad(entity.getCantidad());
				dto.setSubtotal(entity.getSubtotal());
				dto.setPedido(entity.getPedido());
				dto.setArticuloConsumo(entity.getArticuloConsumo());
				dto.setArticuloManufacturado(entity.getArticuloManufacturado());
				dtos.add(dto);
			}
			
			return dtos;
			
		} catch (Exception e) {
			throw new Exception();
		}
	}

public DetallePedidoDto findById(int id) throws Exception{
	
	Optional<DetallePedido>entityOptional = repository.findById((long) id);
	
	DetallePedidoDto dto = new DetallePedidoDto();
	
	try {
		 DetallePedido entity = entityOptional.get();
		
			dto.setId(entity.getId());
			dto.setCantidad(entity.getCantidad());
			dto.setSubtotal(entity.getSubtotal());
			dto.setPedido(entity.getPedido());
			dto.setArticuloConsumo(entity.getArticuloConsumo());
			dto.setArticuloManufacturado(entity.getArticuloManufacturado());
	} catch (Exception e) {
		throw new Exception();
	}
	
	return dto;
}

public DetallePedidoDto save(DetallePedidoDto dto, boolean estado) throws Exception {
	
	DetallePedido entity = new DetallePedido();
	
	entity.setCantidad(dto.getCantidad());
	entity.setSubtotal(dto.getSubtotal());
	entity.setPedido(dto.getPedido());
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

public DetallePedidoDto update(int id, DetallePedidoDto dto, boolean estado) throws Exception {
	Optional<DetallePedido> optionalEntity = repository.findById((long) id);
	
	try {
		 DetallePedido entity = optionalEntity.get();
		    entity.setId(dto.getId());
		    entity.setCantidad(dto.getCantidad());
			entity.setSubtotal(dto.getSubtotal());
			entity.setPedidoDto(dto.getPedido());
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
