package com.example.demo.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
			
			for(ArticuloConsumo i : entities) {
				ArticuloConsumoDto dto = new ArticuloConsumoDto();
				dto.setId(i.getId());
				dto.setDenominacion(i.getDenominacion());
				dto.setPrecioCompra(i.getPrecioCompra());
				dto.setPrecioVenta(i.getPrecioVenta());
				dto.setStockActual(i.getStockActual());
				dto.setStockMinimo(i.getStockMinimo());
				dto.setUnidadMedida(i.getUnidadMedida());
				dto.setEsInsumo(i.isEsInsumo());
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
			 ArticuloConsumo i = entityOptional.get();
			
				dto.setId(i.getId());
				dto.setDenominacion(i.getDenominacion());
				dto.setPrecioCompra(i.getPrecioCompra());
				dto.setPrecioVenta(i.getPrecioVenta());
				dto.setStockActual(i.getStockActual());
				dto.setStockMinimo(i.getStockMinimo());
				dto.setUnidadMedida(i.getUnidadMedida());
				dto.setEsInsumo(i.isEsInsumo());
		} catch (Exception e) {
			throw new Exception();
		}
		
		return dto;
	}
	
		
    public ArticuloConsumoDto save(ArticuloConsumoDto dto, boolean estado) throws Exception {
		
		ArticuloConsumo articuloConsumo = new ArticuloConsumo();
		
		articuloConsumo.setDenominacion(dto.getDenominacion());
		articuloConsumo.setPrecioCompra(dto.getPrecioCompra());
		articuloConsumo.setPrecioVenta(dto.getPrecioVenta());
		articuloConsumo.setStockActual(dto.getStockActual());
		articuloConsumo.setStockMinimo(dto.getStockMinimo());
		articuloConsumo.setUnidadMedida(dto.getUnidadMedida());
		articuloConsumo.setEsInsumo(dto.isEsInsumo());
		
		try {
			articuloConsumo = repository.save(articuloConsumo);
			dto.setId(articuloConsumo.getId());
			return dto;
		} catch (Exception e) {
			throw new Exception();	
		}
		
			
	}
	
	public ArticuloConsumoDto update(int id, ArticuloConsumoDto dto, boolean estado) throws Exception {
		Optional<ArticuloConsumo> optionalEntity = repository.findById((long) id);
		
		try {
			 ArticuloConsumo articuloConsumo = optionalEntity.get();
			 articuloConsumo.setDenominacion(dto.getDenominacion());
				articuloConsumo.setPrecioCompra(dto.getPrecioCompra());
				articuloConsumo.setPrecioVenta(dto.getPrecioVenta());
				articuloConsumo.setStockActual(dto.getStockActual());
				articuloConsumo.setStockMinimo(dto.getStockMinimo());
				articuloConsumo.setUnidadMedida(dto.getUnidadMedida());
				articuloConsumo.setEsInsumo(dto.isEsInsumo());
			 
			 repository.save(articuloConsumo);
			 dto.setId(articuloConsumo.getId());
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
	
	
	
	
	
}

