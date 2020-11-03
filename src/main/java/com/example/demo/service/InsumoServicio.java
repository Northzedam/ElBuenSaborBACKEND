package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dtos.InsumoDto;
import com.example.demo.dtos.UnidadMedidaDto;
import com.example.demo.entity.Insumo;
import com.example.demo.entity.UnidadMedida;
import com.example.demo.repository.InsumoRepository;
import com.example.demo.repository.UnidadMedidaRepository;

@Service
public class InsumoServicio {
	
	InsumoRepository repository;
	UnidadMedidaRepository unidadMedidaRepository;

	public InsumoServicio(InsumoRepository repository, UnidadMedidaRepository unidadMedidaRepository
) {
		this.repository = repository;
		this.unidadMedidaRepository = unidadMedidaRepository;
	}
	
	/*public InsumoServicio(UnidadMedidaRepository unidadMedidaRepository) {
		
	}*/
	
	public List<InsumoDto> findAll() throws Exception {
		
		List<Insumo>entities = repository.findAll();
		List<InsumoDto>dtos = new ArrayList<InsumoDto>();
		try {
			
			for(Insumo entity : entities) {
				InsumoDto dto = new InsumoDto();
				dto.setId(entity.getId());
				dto.setDenominacion(entity.getDenominacion());
				dto.setPrecioCompra(entity.getPrecioCompra());
				dto.setStockActual(entity.getStockActual());
				dto.setStockMinimo(entity.getStockMinimo());
				UnidadMedidaDto unidadMedidaDto = new UnidadMedidaDto();
				unidadMedidaDto.setId(entity.getUnidadMedida().getId());
				unidadMedidaDto.setUnidadMedida(entity.getUnidadMedida().getUnidadMedida());
				dto.setUnidadMedida(unidadMedidaDto);
				dtos.add(dto);
			}
			
			return dtos;
			
		} catch (Exception e) {
			throw new Exception();
		}
		
	}
	
	public InsumoDto findById(long id) throws Exception {
			
		Optional<Insumo>entityOptional = repository.findById((long) id);
		
		InsumoDto dto = new InsumoDto();
		
		try {
			 Insumo entity = entityOptional.get();
			
			    dto.setId(entity.getId());
				dto.setDenominacion(entity.getDenominacion());
				dto.setPrecioCompra(entity.getPrecioCompra());
				dto.setStockActual(entity.getStockActual());
				dto.setStockMinimo(entity.getStockMinimo());
				UnidadMedidaDto unidadMedidaDto = new UnidadMedidaDto();
				unidadMedidaDto.setId(entity.getUnidadMedida().getId());
				unidadMedidaDto.setUnidadMedida(entity.getUnidadMedida().getUnidadMedida());
				dto.setUnidadMedida(unidadMedidaDto);
		} catch (Exception e) {
			throw new Exception();
		}
		
		return dto;
			
	}
	
	 public InsumoDto save(InsumoDto dto, boolean estado) throws Exception {
			
			Insumo entity = new Insumo();
			
			entity.setDenominacion(dto.getDenominacion());
			entity.setPrecioCompra(dto.getPrecioCompra());
			entity.setStockActual(dto.getStockActual());
			entity.setStockMinimo(dto.getStockMinimo());
			try {
				Optional<UnidadMedida>unidadMedidaOptional = unidadMedidaRepository.findById(dto.getUnidadMedidaId());
				entity.setUnidadMedida(unidadMedidaOptional.get());
			} catch (Exception e) {
				throw new Exception("No se encontró la unidad de medida");
			}
			
			
			
			try {
				entity = repository.save(entity);
				dto.setId(entity.getId());
				return dto;
			} catch (Exception e) {
				throw new Exception();	
			}
			
				
	}
	 
	 public InsumoDto update(int id, InsumoDto dto, boolean estado) throws Exception {
			Optional<Insumo> optionalEntity = repository.findById((long) id);
			
			try {
				 Insumo entity = optionalEntity.get();
				    entity.setId(id);
				    entity.setDenominacion(dto.getDenominacion());
					entity.setPrecioCompra(dto.getPrecioCompra());
					entity.setStockActual(dto.getStockActual());
					entity.setStockMinimo(dto.getStockMinimo());
					try {
						Optional<UnidadMedida>unidadMedidaOptional = unidadMedidaRepository.findById(dto.getUnidadMedidaId());
						entity.setUnidadMedida(unidadMedidaOptional.get());
					} catch (Exception e) {
						throw new Exception("No se encontró la unidad de medida");
					}
					
				 
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
	 
}