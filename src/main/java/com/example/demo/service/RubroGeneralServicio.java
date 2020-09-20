package com.example.demo.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.entity.RubroGeneral;
import com.example.demo.repository.RubroGeneralRepository;
import com.example.demo.dtos.RubroGeneralDto;

@Service
public class RubroGeneralServicio {


	RubroGeneralRepository repository;

	public RubroGeneralServicio(RubroGeneralRepository repository) {
		this.repository = repository;
	}
	
	public List<RubroGeneralDto> findAll() throws Exception {
		
		List<RubroGeneral>entities = repository.findAll();
		List<RubroGeneralDto>dtos = new ArrayList<RubroGeneralDto>();
		try {
			
			for(RubroGeneral entity : entities) {
				RubroGeneralDto dto = new RubroGeneralDto();
				dto.setId(entity.getId());
				dto.setDenominacion(entity.getDenominacion());

				dtos.add(dto);
			}
			
			return dtos;
			
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	public RubroGeneralDto findById(int id) throws Exception{
		
		Optional<RubroGeneral>entityOptional = repository.findById((long) id);
		
		RubroGeneralDto dto = new RubroGeneralDto();
		
		try {
			 RubroGeneral entity = entityOptional.get();
			
				dto.setId(entity.getId());
				dto.setDenominacion(entity.getDenominacion());
	
		} catch (Exception e) {
			throw new Exception();
		}
		
		return dto;
	}
	
		
    public RubroGeneralDto save(RubroGeneralDto dto, boolean estado) throws Exception {
		
		RubroGeneral entity = new RubroGeneral();
		
		entity.setDenominacion(dto.getDenominacion());

		try {
			entity = repository.save(entity);
			dto.setId(entity.getId());
			return dto;
		} catch (Exception e) {
			throw new Exception();	
		}
		
			
	}
	
	public RubroGeneralDto update(int id, RubroGeneralDto dto, boolean estado) throws Exception {
		Optional<RubroGeneral> optionalEntity = repository.findById((long) id);
		
		try {
			 RubroGeneral entity = optionalEntity.get();
			    entity.setId(dto.getId());
			    entity.setDenominacion(dto.getDenominacion());
	
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

