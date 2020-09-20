package com.example.demo.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.entity.ArticuloConsumo;
import com.example.demo.repository.ArticuloConsumoRepository;
import com.example.demo.dtos.ArticuloConsumoDto;

@Service
public class ArticuloConsumoServicio {


	ArticuloConsumoRepository repository;

	public ArticuloConsumoServicio(ArticuloConsumoRepository repository) {
		this.repository = repository;
	}
	
	public List<ArticuloConsumoDto> findAll() throws Exception {
		
		List<ArticuloConsumo>entities = repository.findAll();
		List<ArticuloConsumoDto>dtos = new ArrayList<ArticuloConsumoDto>();
		try {
			
			for(ArticuloConsumo entity : entities) {
				ArticuloConsumoDto dto = new ArticuloConsumoDto();
				dto.setId(entity.getId());
				dto.setDenominacion(entity.getDenominacion());
				dto.setPrecioCompra(entity.getPrecioCompra());
				dto.setPrecioVenta(entity.getPrecioVenta());
				dto.setStockActual(entity.getStockActual());
				dto.setStockMinimo(entity.getStockMinimo());
				dto.setUnidadMedida(entity.getUnidadMedida());
				dto.setEsInsumo(entity.isEsInsumo());
				dtos.add(dto);
			}
			
			return dtos;
			
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	public ArticuloConsumoDto findById(int id) throws Exception{
		
		Optional<ArticuloConsumo>entityOptional = repository.findById((long) id);
		
		ArticuloConsumoDto dto = new ArticuloConsumoDto();
		
		try {
			 ArticuloConsumo entity = entityOptional.get();
			
				dto.setId(entity.getId());
				dto.setDenominacion(entity.getDenominacion());
				dto.setPrecioCompra(entity.getPrecioCompra());
				dto.setPrecioVenta(entity.getPrecioVenta());
				dto.setStockActual(entity.getStockActual());
				dto.setStockMinimo(entity.getStockMinimo());
				dto.setUnidadMedida(entity.getUnidadMedida());
				dto.setEsInsumo(entity.isEsInsumo());
		} catch (Exception e) {
			throw new Exception();
		}
		
		return dto;
	}
	
		
    public ArticuloConsumoDto save(ArticuloConsumoDto dto, boolean estado) throws Exception {
		
		ArticuloConsumo entity = new ArticuloConsumo();
		
		entity.setDenominacion(dto.getDenominacion());
		entity.setPrecioCompra(dto.getPrecioCompra());
		entity.setPrecioVenta(dto.getPrecioVenta());
		entity.setStockActual(dto.getStockActual());
		entity.setStockMinimo(dto.getStockMinimo());
		entity.setUnidadMedida(dto.getUnidadMedida());
		entity.setEsInsumo(dto.isEsInsumo());
		
		try {
			entity = repository.save(entity);
			dto.setId(entity.getId());
			return dto;
		} catch (Exception e) {
			throw new Exception();	
		}
		
			
	}
	
	public ArticuloConsumoDto update(int id, ArticuloConsumoDto dto, boolean estado) throws Exception {
		Optional<ArticuloConsumo> optionalEntity = repository.findById((long) id);
		
		try {
			 ArticuloConsumo entity = optionalEntity.get();
			    entity.setId(dto.getId());
			 	entity.setDenominacion(dto.getDenominacion());
				entity.setPrecioCompra(dto.getPrecioCompra());
				entity.setPrecioVenta(dto.getPrecioVenta());
				entity.setStockActual(dto.getStockActual());
				entity.setStockMinimo(dto.getStockMinimo());
				entity.setUnidadMedida(dto.getUnidadMedida());
				entity.setEsInsumo(dto.isEsInsumo());
			 
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

