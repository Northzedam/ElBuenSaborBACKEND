package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dtos.UnidadMedidaDto;
import com.example.demo.entity.UnidadMedida;
import com.example.demo.repository.UnidadMedidaRepository;

@Service
public class UnidadMedidaServicio {
	
	UnidadMedidaRepository repository;

	public UnidadMedidaServicio(UnidadMedidaRepository repository) {
		this.repository = repository;
	}
	
	public List<UnidadMedidaDto> findAll() throws Exception {
		
		List<UnidadMedida>entities = repository.findAll();
		List<UnidadMedidaDto>dtos = new ArrayList<UnidadMedidaDto>();
		try {
			
			for(UnidadMedida entity : entities) {
				UnidadMedidaDto dto = new UnidadMedidaDto();
				dto.setId(entity.getId());
				dto.setUnidadMedida(entity.getUnidadMedida());
				dtos.add(dto);
			}
			
			return dtos;
			
		} catch (Exception e) {
			throw new Exception();
		}
		
	}
	
	public UnidadMedidaDto findById(long id) throws Exception {
			
		Optional<UnidadMedida>entityOptional = repository.findById((long) id);
		
		UnidadMedidaDto dto = new UnidadMedidaDto();
		
		try {
			 UnidadMedida entity = entityOptional.get();
			
			 dto.setId(entity.getId());
			 dto.setUnidadMedida(entity.getUnidadMedida());
			 
		} catch (Exception e) {
			throw new Exception();
		}
		
		return dto;
			
	}
	
	 public UnidadMedidaDto save(UnidadMedidaDto dto, boolean estado) throws Exception {
			
			UnidadMedida entity = new UnidadMedida();
			
			entity.setUnidadMedida(dto.getUnidadMedida());		
			
			try {
				entity = repository.save(entity);
				dto.setId(entity.getId());
				return dto;
			} catch (Exception e) {
				throw new Exception();	
			}
			
				
	}
	 
	 public UnidadMedidaDto update(int id, UnidadMedidaDto dto, boolean estado) throws Exception {
			Optional<UnidadMedida> optionalEntity = repository.findById((long) id);
			
			try {
				 UnidadMedida entity = optionalEntity.get();
				    entity.setId(id);
					entity.setUnidadMedida(dto.getUnidadMedida());		
				 
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
	 
}