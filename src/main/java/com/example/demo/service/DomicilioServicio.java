package com.example.demo.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Domicilio;
import com.example.demo.repository.DomicilioRepository;
import com.example.demo.dtos.DomicilioDto;

@Service
public class DomicilioServicio {


	DomicilioRepository repository;

	public DomicilioServicio(DomicilioRepository repository) {
		this.repository = repository;
	}
	
	public List<DomicilioDto> findAll() throws Exception {
		
		List<Domicilio>entities = repository.findAll();
		List<DomicilioDto>dtos = new ArrayList<DomicilioDto>();
		try {
			
			for(Domicilio entity : entities) {
				DomicilioDto dto = new DomicilioDto();
				dto.setId(entity.getId());
				dto.setCalle(entity.getCalle());
				dto.setNumero(entity.getNumero());
				dto.setLocalidad(entity.getLocalidad());
				dtos.add(dto);
			}
			
			return dtos;
			
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	public DomicilioDto findById(int id) throws Exception{
		
		Optional<Domicilio>entityOptional = repository.findById((long) id);
		
		DomicilioDto dto = new DomicilioDto();
		
		try {
			 Domicilio entity = entityOptional.get();
			
				dto.setId(entity.getId());
				dto.setCalle(entity.getCalle());
				dto.setNumero(entity.getNumero());
				dto.setLocalidad(entity.getLocalidad());
		} catch (Exception e) {
			throw new Exception();
		}
		
		return dto;
	}
	
		
    public DomicilioDto save(DomicilioDto dto, boolean estado) throws Exception {
		
		Domicilio entity = new Domicilio();
		
		entity.setCalle(dto.getCalle());
		entity.setNumero(dto.getNumero());
		entity.setLocalidad(dto.getLocalidad());
		
		
		try {
			entity = repository.save(entity);
			dto.setId(entity.getId());
			return dto;
		} catch (Exception e) {
			throw new Exception();	
		}
		
			
	}
	
	public DomicilioDto update(int id, DomicilioDto dto, boolean estado) throws Exception {
		Optional<Domicilio> optionalEntity = repository.findById((long) id);
		
		try {
			 Domicilio entity = optionalEntity.get();
			    entity.setId(id);
			    entity.setCalle(dto.getCalle());
				entity.setNumero(dto.getNumero());
				entity.setLocalidad(dto.getLocalidad());
			 
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
	
	public Domicilio getDomicilioEntityById(long id) {
		System.out.println("Entre");
		Domicilio entity = new Domicilio();
		try {
			Optional<Domicilio>entityOptional = repository.findById(id);
			entity = entityOptional.get();
		} catch (Exception e) {
			System.out.println("Error en getDomicilioEntityById: " + e.getMessage());
		}
		
		return entity;
	}
	
	
	public int countPages(int size) throws Exception {
		try {
			Pageable pageable = PageRequest.of(0, size);
			return repository.findAll(pageable).getTotalPages();			

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public void saveDomEntity(Domicilio dom) {
		this.repository.save(dom);		
	}
	
	
}

