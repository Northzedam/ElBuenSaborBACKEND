package com.example.demo.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.ArticuloManufacturadoDto;
import com.example.demo.entity.ArticuloManufacturado;
import com.example.demo.repository.ArticuloManufacturadoRepository;

@Service
public class ArticuloManufacturadoServicio {


	ArticuloManufacturadoRepository repository;

	public ArticuloManufacturadoServicio(ArticuloManufacturadoRepository repository) {
		this.repository = repository;
	}
	
	public List<ArticuloManufacturadoDto> findAll() throws Exception {
		
		List<ArticuloManufacturado>entities = repository.findAll();
		List<ArticuloManufacturadoDto>dtos = new ArrayList<ArticuloManufacturadoDto>();
		try {
			
			for(ArticuloManufacturado entity : entities) {
				ArticuloManufacturadoDto dto = new ArticuloManufacturadoDto();
				dto.setId(entity.getId());
				dto.setTiempoEstimadoCocina(entity.getTiempoEstimadoCocina());
				dto.setDenominacion(entity.getDenominacion());
				dto.setPrecioVenta(entity.getPrecioVenta());
				
				dtos.add(dto);
			}
			
			return dtos;
			
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	public ArticuloManufacturadoDto findById(int id) throws Exception{
		
		Optional<ArticuloManufacturado>entityOptional = repository.findById((long) id);
		
		ArticuloManufacturadoDto dto = new ArticuloManufacturadoDto();
		
		try {
			 ArticuloManufacturado entity = entityOptional.get();
			
				dto.setId(entity.getId());
				dto.setTiempoEstimadoCocina(entity.getTiempoEstimadoCocina());
				dto.setDenominacion(entity.getDenominacion());
				dto.setPrecioVenta(entity.getPrecioVenta());
		} catch (Exception e) {
			throw new Exception();
		}
		
		return dto;
	}
	
		
    public ArticuloManufacturadoDto save(ArticuloManufacturadoDto dto, boolean estado) throws Exception {
		
		ArticuloManufacturado entity = new ArticuloManufacturado();
		
		entity.setTiempoEstimadoCocina(dto.getTiempoEstimadoCocina());
		entity.setDenominacion(dto.getDenominacion());
		entity.setPrecioVenta(dto.getPrecioVenta());
		
		try {
			entity = repository.save(entity);
			dto.setId(entity.getId());
			return dto;
		} catch (Exception e) {
			throw new Exception();	
		}
		
			
	}
	
	public ArticuloManufacturadoDto update(int id, ArticuloManufacturadoDto dto, boolean estado) throws Exception {
		Optional<ArticuloManufacturado> optionalEntity = repository.findById((long) id);
		
		try {
			 ArticuloManufacturado entity = optionalEntity.get();
			 entity.setId(dto.getId());
			 entity.setTiempoEstimadoCocina(dto.getTiempoEstimadoCocina());
             entity.setDenominacion(dto.getDenominacion());
             entity.setPrecioVenta(dto.getPrecioVenta());		 
			 repository.save(entity);
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

