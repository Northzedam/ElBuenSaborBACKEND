package com.example.demo.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Empleado;
import com.example.demo.repository.EmpleadoRepository;
import com.example.demo.dtos.DomicilioDto;
import com.example.demo.dtos.EmpleadoDto;
import com.example.demo.entity.Domicilio;

@Service
public class EmpleadoServicio {


	EmpleadoRepository repository;

	public EmpleadoServicio(EmpleadoRepository repository) {
		this.repository = repository;
	}
	
	public List<EmpleadoDto> findAll() throws Exception {
		
		List<Empleado>entities = repository.findAll();
		List<EmpleadoDto>dtos = new ArrayList<EmpleadoDto>();
		try {
			
			for(Empleado entity : entities) {
				EmpleadoDto dto = new EmpleadoDto();
				dto.setId(entity.getId());
				dto.setNombre(entity.getNombre());
				dto.setApellido(entity.getApellido());
				dto.setTelefono(entity.getTelefono());
				dto.setEmail(entity.getEmail());
				dto.setCuil(entity.getCuil());
                
				DomicilioDto domicilioDto = new DomicilioDto();
				Domicilio domicilioEntity = entity.getDomicilio();
				domicilioDto.setId(domicilioEntity.getId());
				domicilioDto.setCalle(domicilioEntity.getCalle());
				domicilioDto.setNumero(domicilioEntity.getNumero());
				domicilioDto.setLocalidad(domicilioEntity.getLocalidad());
				domicilioDto.setDepartamento(domicilioEntity.getDepartamento());
				
				dtos.add(dto);
			}
			
			return dtos;
			
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	public EmpleadoDto findById(int id) throws Exception{
		
		Optional<Empleado>entityOptional = repository.findById((long) id);
		
		EmpleadoDto dto = new EmpleadoDto();
		
		try {
			 Empleado entity = entityOptional.get();
			
				dto.setId(entity.getId());
				dto.setNombre(entity.getNombre());
				dto.setApellido(entity.getApellido());
				dto.setTelefono(entity.getTelefono());
				dto.setEmail(entity.getEmail());
				dto.setCuil(entity.getCuil());
				
				DomicilioDto domicilioDto = new DomicilioDto();
				Domicilio domicilioEntity = entity.getDomicilio();
				domicilioDto.setId(domicilioEntity.getId());
				domicilioDto.setCalle(domicilioEntity.getCalle());
				domicilioDto.setNumero(domicilioEntity.getNumero());
				domicilioDto.setLocalidad(domicilioEntity.getLocalidad());
				domicilioDto.setDepartamento(domicilioEntity.getDepartamento());
				

		} catch (Exception e) {
			throw new Exception();
		}
		
		return dto;
	}
	
		
    public EmpleadoDto save(EmpleadoDto dto, boolean estado) throws Exception {
		
		Empleado entity = new Empleado();
		
		entity.setNombre(dto.getNombre());
		entity.setApellido(dto.getApellido());
		entity.setTelefono(dto.getTelefono());
		entity.setEmail(dto.getEmail());
		entity.setCuil(dto.getCuil());


		
		
		try {
			entity = repository.save(entity);
			dto.setId(entity.getId());
			return dto;
		} catch (Exception e) {
			throw new Exception();	
		}
		
			
	}
	
	public EmpleadoDto update(int id, EmpleadoDto dto, boolean estado) throws Exception {
		Optional<Empleado> optionalEntity = repository.findById((long) id);
		
		try {
			 Empleado entity = optionalEntity.get();
			    entity.setId(id);
			    entity.setNombre(dto.getNombre());
				entity.setApellido(dto.getApellido());
				entity.setTelefono(dto.getTelefono());
				entity.setEmail(dto.getEmail());
				entity.setCuil(dto.getCuil());

			 
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

