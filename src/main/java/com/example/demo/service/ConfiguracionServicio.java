package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.ConfiguracionDto;
import com.example.demo.entity.Configuracion;
import com.example.demo.repository.ConfiguracionRepository;

@Service
public class ConfiguracionServicio{

	ConfiguracionRepository repository;

	public ConfiguracionServicio(ConfiguracionRepository repository) {
		super();
		this.repository = repository;
	}
	
public List<ConfiguracionDto> findAll() throws Exception {
		
		List<Configuracion>entities = repository.findAll();
		List<ConfiguracionDto>dtos = new ArrayList<ConfiguracionDto>();
		try {
			
			for(Configuracion entity : entities) {
				ConfiguracionDto dto = new ConfiguracionDto();
				dto.setId(entity.getId());
				dto.setEmailEmpresa(entity.getEmailEmpresa());
				dto.setCantidadCocinero(entity.getCantidadCocinero());
				dtos.add(dto);
			}
			
			return dtos;
			
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
public ConfiguracionDto findById(int id) throws Exception{
	
	Optional<Configuracion>entityOptional = repository.findById((long) id);
	
	ConfiguracionDto dto = new ConfiguracionDto();
	
	try {
		 Configuracion entity = entityOptional.get();
		
		 dto.setId(entity.getId());
			dto.setEmailEmpresa(entity.getEmailEmpresa());
			dto.setCantidadCocinero(entity.getCantidadCocinero());
			
	} catch (Exception e) {
		throw new Exception();
	}
	
	return dto;
}

public ConfiguracionDto save(ConfiguracionDto dto, boolean estado) throws Exception {
	
	Configuracion entity = new Configuracion();
	
	entity.setEmailEmpresa(dto.getEmailEmpresa());
	entity.setCantidadCocinero(dto.getCantidadCocinero());
		
	try {
		entity = repository.save(entity);
		dto.setId(entity.getId());
		return dto;
	} catch (Exception e) {
		throw new Exception();	
	}
	
		
}

public ConfiguracionDto update(int id, ConfiguracionDto dto, boolean estado) throws Exception {
	Optional<Configuracion> optionalEntity = repository.findById((long) id);
	
	try {
		 Configuracion entity = optionalEntity.get();
		    entity.setId(dto.getId());
		    entity.setEmailEmpresa(dto.getEmailEmpresa());
			entity.setCantidadCocinero(dto.getCantidadCocinero());
		 
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
