package com.example.demo.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.ArticuloManufacturadoDetalleDto;
import com.example.demo.entity.ArticuloManufacturadoDetalle;
import com.example.demo.repository.ArticuloManufacturadoDetalleRepository;

@Service
public class ArticuloManufacturadoDetalleServicio {


	ArticuloManufacturadoDetalleRepository repository;

	public ArticuloManufacturadoDetalleServicio(ArticuloManufacturadoDetalleRepository repository) {
		this.repository = repository;
	}
	
	public List<ArticuloManufacturadoDetalleDto> findAll() throws Exception {
		
		List<ArticuloManufacturadoDetalle>entities = repository.findAll();
		List<ArticuloManufacturadoDetalleDto>dtos = new ArrayList<ArticuloManufacturadoDetalleDto>();
		try {
			
			for(ArticuloManufacturadoDetalle entity : entities) {
				ArticuloManufacturadoDetalleDto dto = new ArticuloManufacturadoDetalleDto();
				dto.setId(entity.getId());
				dto.setCantidad(entity.getCantidad());
				dto.setUnidadMedida(entity.getUnidadMedida());
				
				dtos.add(dto);
			}
			
			return dtos;
			
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	public ArticuloManufacturadoDetalleDto findById(int id) throws Exception{
		
		Optional<ArticuloManufacturadoDetalle>entityOptional = repository.findById((long) id);
		
		ArticuloManufacturadoDetalleDto dto = new ArticuloManufacturadoDetalleDto();
		
		try {
			 ArticuloManufacturadoDetalle entity = entityOptional.get();
			
				dto.setId(entity.getId());
				dto.setCantidad(entity.getCantidad());
				dto.setUnidadMedida(entity.getUnidadMedida());
		} catch (Exception e) {
			throw new Exception();
		}
		
		return dto;
	}
	
		
    public ArticuloManufacturadoDetalleDto save(ArticuloManufacturadoDetalleDto dto, boolean estado) throws Exception {
		
		ArticuloManufacturadoDetalle entity = new ArticuloManufacturadoDetalle();
		
		entity.setCantidad(dto.getCantidad());
		entity.setUnidadMedida(dto.getUnidadMedida());
		
		try {
			entity = repository.save(entity);
			dto.setId(entity.getId());
			return dto;
		} catch (Exception e) {
			throw new Exception();	
		}
		
			
	}
	
	public ArticuloManufacturadoDetalleDto update(int id, ArticuloManufacturadoDetalleDto dto, boolean estado) throws Exception {
		Optional<ArticuloManufacturadoDetalle> optionalEntity = repository.findById((long) id);
		
		try {
			 ArticuloManufacturadoDetalle entity = optionalEntity.get();
			 entity.setId(dto.getId());
			 entity.setCantidad(dto.getCantidad());
			 entity.setUnidadMedida(dto.getUnidadMedida());			 
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

