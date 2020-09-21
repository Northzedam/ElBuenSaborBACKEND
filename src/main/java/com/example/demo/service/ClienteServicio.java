package com.example.demo.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.example.demo.dtos.ClienteDto;
import com.example.demo.entity.Cliente;

import com.example.demo.repository.ClienteRepository;

@Service
public class ClienteServicio{
	
	ClienteRepository repository;

	public ClienteServicio(ClienteRepository repository) {
		this.repository = repository;
	}
	
public List<ClienteDto> findAll() throws Exception {
		
		List<Cliente>entities = repository.findAll();
		List<ClienteDto>dtos = new ArrayList<ClienteDto>();
		try {
			
			for(Cliente entity : entities) {
				ClienteDto dto = new ClienteDto();
				dto.setId(entity.getId());
				dto.setNombre(entity.getNombre());
				dto.setApellido(entity.getApellido());
				dto.setTelefono(entity.getTelefono());
				dto.setEmail(entity.getEmail());
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
			
					
	} catch (Exception e) {
		throw new Exception();
	}
	
	return dto;
}

public ClienteDto save(ClienteDto dto, boolean estado) throws Exception {
	
	Cliente entity = new Cliente();
	
	entity.setNombre(dto.getNombre());
	entity.setApellido(dto.getApellido());
	entity.setTelefono(dto.getTelefono());
	entity.setEmail(dto.getEmail());
	
		
	try {
		entity = repository.save(entity);
		dto.setId(entity.getId());
		return dto;
	} catch (Exception e) {
		throw new Exception();	
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
