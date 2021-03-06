package com.example.demo.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Factura;
import com.example.demo.repository.FacturaRepository;
import com.example.demo.dtos.FacturaDto;

@Service
public class FacturaServicio {


	FacturaRepository repository;

	public FacturaServicio(FacturaRepository repository) {
		this.repository = repository;
	}
	
	public List<FacturaDto> findAll() throws Exception {
		
		List<Factura>entities = repository.findAll();
		List<FacturaDto>dtos = new ArrayList<FacturaDto>();
		try {
			
			for(Factura entity : entities) {
				FacturaDto dto = new FacturaDto();
				dto.setId(entity.getId());
				dto.setFecha(entity.getFecha());
				dto.setNumero(entity.getNumero());
				dto.setMontoDescuento(entity.getMontoDescuento());
				dto.setTotal(entity.getTotal());
				dto.setFormaDePago(entity.getFormaDePago());
				dto.setNroTarjeta(entity.getNroTarjeta());

				dtos.add(dto);
			}
			
			return dtos;
			
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	public FacturaDto findById(int id) throws Exception{
		
		Optional<Factura>entityOptional = repository.findById((long) id);
		
		FacturaDto dto = new FacturaDto();
		
		try {
			 Factura entity = entityOptional.get();
			
				dto.setId(entity.getId());
				dto.setFecha(entity.getFecha());
				dto.setNumero(entity.getNumero());
				dto.setMontoDescuento(entity.getMontoDescuento());
				dto.setTotal(entity.getTotal());
				dto.setFormaDePago(entity.getFormaDePago());
				dto.setNroTarjeta(entity.getNroTarjeta());


		} catch (Exception e) {
			throw new Exception();
		}
		
		return dto;
	}
	
		
    public FacturaDto save(FacturaDto dto, boolean estado) throws Exception {
		
		Factura entity = new Factura();
		
		entity.setFecha(dto.getFecha());
		entity.setNumero(dto.getNumero());
		entity.setMontoDescuento(dto.getMontoDescuento());
		entity.setTotal(dto.getTotal());
		entity.setFormaDePago(dto.getFormaDePago());
		entity.setNroTarjeta(dto.getNroTarjeta());



		
		
		try {
			entity = repository.save(entity);
			dto.setId(entity.getId());
			return dto;
		} catch (Exception e) {
			throw new Exception();	
		}
		
			
	}
	
	public FacturaDto update(int id, FacturaDto dto, boolean estado) throws Exception {
		Optional<Factura> optionalEntity = repository.findById((long) id);
		
		try {
			 Factura entity = optionalEntity.get();
			    entity.setId(id);
			    entity.setFecha(dto.getFecha());
				entity.setNumero(dto.getNumero());
				entity.setMontoDescuento(dto.getMontoDescuento());
				entity.setTotal(dto.getTotal());
				entity.setFormaDePago(dto.getFormaDePago());
				entity.setNroTarjeta(dto.getNroTarjeta());



			 
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

