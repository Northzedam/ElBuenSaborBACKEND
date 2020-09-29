package com.example.demo.service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.ElBuenSabor2020Application;
import com.example.demo.dtos.ArticuloManufacturadoDto;
import com.example.demo.entity.ArticuloManufacturado;
import com.example.demo.repository.ArticuloManufacturadoRepository;

@Service
public class ArticuloManufacturadoServicio {


	ArticuloManufacturadoRepository repository;
	private String upload_folder = String.valueOf(ElBuenSabor2020Application.getHome()+ "\\images\\").replace("\\","/");


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
				dto.setImagen(entity.getImagen());
				
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
				dto.setImagen(entity.getImagen());
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

	
	public ArticuloManufacturadoDto update(int id, ArticuloManufacturadoDto dto, boolean estado) throws Exception {
		Optional<ArticuloManufacturado> optionalEntity = repository.findById((long) id);
		
		try {
			 ArticuloManufacturado entity = optionalEntity.get();
			 entity.setId(id);
			 entity.setTiempoEstimadoCocina(dto.getTiempoEstimadoCocina());
             entity.setDenominacion(dto.getDenominacion());
             entity.setPrecioVenta(dto.getPrecioVenta());	
             entity.setImagen(dto.getImagen());
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

