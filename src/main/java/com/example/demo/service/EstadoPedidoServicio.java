package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.example.demo.dtos.EstadoPedidoDto;
import com.example.demo.entity.EstadoPedido;
import com.example.demo.repository.EstadoPedidoRepository;

@Service
public class EstadoPedidoServicio {

	
	EstadoPedidoRepository repository;

	public EstadoPedidoServicio(EstadoPedidoRepository repository) {
		this.repository = repository;
	}
	
    public List<EstadoPedidoDto> findAll() throws Exception {
		
		List<EstadoPedido>entities = repository.findAll();
		List<EstadoPedidoDto>dtos = new ArrayList<EstadoPedidoDto>();
		try {
			
			for(EstadoPedido entity : entities) {
				EstadoPedidoDto dto = new EstadoPedidoDto();
				dto.setId(entity.getId());
				dto.setEstadoPedido(entity.getEstadoPedido());
				dtos.add(dto);
			}
			
			return dtos;
			
		} catch (Exception e) {
			throw new Exception();
		}
	}
    
    public EstadoPedidoDto findById(long id) throws Exception{
		
		Optional<EstadoPedido>entityOptional = repository.findById(id);
		
		EstadoPedidoDto dto = new EstadoPedidoDto();
		
		try {
			EstadoPedido entity = entityOptional.get();
			dto.setId(entity.getId());
			dto.setEstadoPedido(entity.getEstadoPedido());
			
		} catch (Exception e) {
			throw new Exception();
		}
		
		return dto;
	}
    
    
 public EstadoPedidoDto save(EstadoPedidoDto dto, boolean estado) throws Exception {
		
	 EstadoPedido entity = new EstadoPedido();
		
		entity.setId(dto.getId());
		entity.setEstadoPedido(dto.getEstadoPedido());		
		
		try {
			entity = repository.save(entity);
			dto.setId(entity.getId());
			return dto;
		} catch (Exception e) {
			throw new Exception();	
		}
		
			
	}
	
	public EstadoPedidoDto update(int id, EstadoPedidoDto dto, boolean estado) throws Exception {
		Optional<EstadoPedido> optionalEntity = repository.findById((long) id);
		
		try {
			EstadoPedido entity = optionalEntity.get();
			    entity.setId(id);
			    entity.setEstadoPedido(dto.getEstadoPedido());;
			
			 
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
