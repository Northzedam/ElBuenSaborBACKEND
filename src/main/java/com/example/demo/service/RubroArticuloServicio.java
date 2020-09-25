package com.example.demo.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.entity.RubroArticulo;
import com.example.demo.repository.RubroArticuloRepository;
import com.example.demo.dtos.RubroArticuloDto;

@Service
public class RubroArticuloServicio {


	RubroArticuloRepository repository;

	public RubroArticuloServicio(RubroArticuloRepository repository) {
		this.repository = repository;
	}
	
	public List<RubroArticuloDto> findAll() throws Exception {
		
		List<RubroArticulo>entities = repository.findAll();
		List<RubroArticuloDto>dtos = new ArrayList<RubroArticuloDto>();
		try {
			
			for(RubroArticulo entity : entities) {
				RubroArticuloDto dto = new RubroArticuloDto();
				dto.setId(entity.getId());
				dto.setDenominacion(entity.getDenominacion());
			//	dto.setRubroArticulo(entity.getRubroArticulo());
			
				dtos.add(dto);
			}
			
			return dtos;
			
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	public RubroArticuloDto findById(int id) throws Exception{
		
		Optional<RubroArticulo>entityOptional = repository.findById((long) id);
		
		RubroArticuloDto dto = new RubroArticuloDto();
		
		try {
			 RubroArticulo entity = entityOptional.get();
			
				dto.setId(entity.getId());
				dto.setDenominacion(entity.getDenominacion());
				//dto.setRubroArticulo(entity.getRubroArticulo());
		
		} catch (Exception e) {
			throw new Exception();
		}
		
		return dto;
	}
	
		
    public RubroArticuloDto save(RubroArticuloDto dto, boolean estado) throws Exception {
		
		RubroArticulo entity = new RubroArticulo();
		
		entity.setDenominacion(dto.getDenominacion());
		//entity.setRubroArticulo(dto.getRubroArticulo());
	
		
		try {
			entity = repository.save(entity);
			dto.setId(entity.getId());
			return dto;
		} catch (Exception e) {
			throw new Exception();	
		}
		
			
	}
	
	public RubroArticuloDto update(int id, RubroArticuloDto dto, boolean estado) throws Exception {
		Optional<RubroArticulo> optionalEntity = repository.findById((long) id);
		
		try {
			 RubroArticulo entity = optionalEntity.get();
			    entity.setId(id);
			    entity.setDenominacion(dto.getDenominacion());
				//entity.setRubroArticulo(dto.getRubroArticulo());
						 
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

