package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dtos.ParametrosDto;
import com.example.demo.dtos.ClienteDto;
import com.example.demo.entity.Parametros;
import com.example.demo.entity.Cliente;
import com.example.demo.repository.ParametrosRepository;


@Service
public class ParametrosServicio {
	
	ParametrosRepository repository;
	
	public ParametrosServicio(ParametrosRepository repository) {
		this.repository = repository;
	}
	
	public List<ParametrosDto> findAll() throws Exception{
		
		List<Parametros> entities = repository.findAll();
		List<ParametrosDto> dtos = new ArrayList<ParametrosDto>();
		
		try {
			
			for(Parametros entity : entities) {
				ParametrosDto dto = new ParametrosDto();
				dto.setId(entity.getId());
				dto.setCantidadCocineros(entity.getCantidadCocineros());
				dto.setHorarioAperturaDiurno(entity.getHorarioAperturaDiurno());
				dto.setHorarioClausuraDiurno(entity.getHorarioClausuraDiurno());
				dto.setHorarioAperturaNocturno(entity.getHorarioAperturaNocturno());
				dto.setHorarioClausuraNocturno(entity.getHorarioClausuraNocturno());
				
				dtos.add(dto);
			}
			return dtos;
			
		} catch (Exception e) {
			
			throw new Exception();
			
		}
		
	}
	
	public ParametrosDto findById(int id) throws Exception{
		
		Optional<Parametros>entityOptional = repository.findById((long) id);
		
		ParametrosDto dto = new ParametrosDto();
		
		try {
			
			Parametros entity = entityOptional.get();
			dto.setId(entity.getId());
			dto.setCantidadCocineros(entity.getCantidadCocineros());
			dto.setHorarioAperturaDiurno(entity.getHorarioAperturaDiurno());
			dto.setHorarioClausuraDiurno(entity.getHorarioClausuraDiurno());
			dto.setHorarioAperturaNocturno(entity.getHorarioAperturaNocturno());
			dto.setHorarioClausuraNocturno(entity.getHorarioClausuraNocturno());
			
		} catch (Exception e) {
			
			throw new Exception();
		}
		
		
		return dto;
	}
	
	public ParametrosDto save(ParametrosDto dto, boolean estado) throws Exception{
		
		Parametros entity = new Parametros();
		entity.setCantidadCocineros(dto.getCantidadCocineros());
		entity.setHorarioAperturaDiurno(dto.getHorarioAperturaDiurno());
		entity.setHorarioClausuraDiurno(dto.getHorarioClausuraDiurno());
		entity.setHorarioAperturaNocturno(dto.getHorarioAperturaNocturno());
		entity.setHorarioClausuraNocturno(dto.getHorarioClausuraNocturno());
		
		try {
			entity = repository.save(entity);
			dto.setId(entity.getId());
			return dto;
			
		} catch (Exception e) {

			throw new Exception();
		}
				
	}
	
	public ParametrosDto update(int id, ParametrosDto dto, boolean estado) throws Exception{
		
		Optional<Parametros> optionalEntity = repository.findById((long) id);
		
		try {
			Parametros entity = optionalEntity.get();
			entity.setId(id);
			entity.setCantidadCocineros(dto.getCantidadCocineros());
			entity.setHorarioAperturaDiurno(dto.getHorarioAperturaDiurno());
			entity.setHorarioClausuraDiurno(dto.getHorarioClausuraDiurno());
			entity.setHorarioAperturaNocturno(dto.getHorarioAperturaNocturno());
			entity.setHorarioClausuraNocturno(dto.getHorarioClausuraNocturno());
			
			 repository.save(entity);
			 dto.setId(entity.getId());
			 return  dto;
			
		} catch (Exception e) {
			
			throw new Exception();	

		}
		
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
	
	public int getNumeroCocineros() {
		int numCocineros = 1;
		List<Parametros> lista = new ArrayList<Parametros>();
		
		try {
			lista = repository.findAll();
			
			if(lista.size() > 0) {
				numCocineros = lista.get(0).getCantidadCocineros();
			}
			
		} catch (Exception e) {
			System.out.println("Conflicto en método 'numeroCocineros' en ParametrosService: " + e.getMessage());;
		}
		
		
		return numCocineros;		
	}

}
