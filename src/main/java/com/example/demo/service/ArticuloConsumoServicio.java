package com.example.demo.service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.ArticuloConsumo;
import com.example.demo.repository.ArticuloConsumoRepository;
import com.example.demo.ElBuenSabor2020Application;
import com.example.demo.dtos.ArticuloConsumoDto;

@Service
public class ArticuloConsumoServicio {


	ArticuloConsumoRepository repository;
	private String upload_folder = String.valueOf(ElBuenSabor2020Application.getHome()+ "\\images\\").replace("\\","/");


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
				dto.setImagen(entity.getImagen());

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
				dto.setImagen(entity.getImagen());

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
		entity.setImagen(dto.getImagen());

		
		try {
			entity = repository.save(entity);
			dto.setId(entity.getId());
			return dto;
		} catch (Exception e) {
			throw new Exception();	
		}
		
			
	}
    
    public String saveImage(MultipartFile file) throws IOException {
		if(!file.isEmpty()) {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(upload_folder + file.getOriginalFilename());
			Files.write(path, bytes);
		}
		return(upload_folder);
		
	}

	
	public ArticuloConsumoDto update(int id, ArticuloConsumoDto dto, boolean estado) throws Exception {
		Optional<ArticuloConsumo> optionalEntity = repository.findById((long) id);
		
		try {
			 ArticuloConsumo entity = optionalEntity.get();
			    entity.setId(id);
			 	entity.setDenominacion(dto.getDenominacion());
				entity.setPrecioCompra(dto.getPrecioCompra());
				entity.setPrecioVenta(dto.getPrecioVenta());
				entity.setStockActual(dto.getStockActual());
				entity.setStockMinimo(dto.getStockMinimo());
				entity.setUnidadMedida(dto.getUnidadMedida());
				entity.setEsInsumo(dto.isEsInsumo());
				entity.setImagen(dto.getImagen());

			 
			 repository.save(entity);
			 dto.setId(entity.getId());
			 return dto;
			 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dto;
	}
	
	public double updateStock(long id, double cantidad, boolean esIngreso) throws Exception {
		Optional<ArticuloConsumo> optionalEntity = repository.findById((long) id);
		double stockActualizado=0;
		try {
			 ArticuloConsumo entity = optionalEntity.get();
			    entity.setId(id);
			    if(esIngreso){ // si esIngreso es true es porque se esta ingresando stock, sino es porque se hizo un pedido y se esta restando al stock actual
					entity.setStockActual(entity.getStockActual() + cantidad);
			    }else{
					entity.setStockActual(entity.getStockActual() - cantidad);
			    }
			 
			 repository.save(entity);
			 stockActualizado = entity.getStockActual();
			 
			 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return stockActualizado;
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

