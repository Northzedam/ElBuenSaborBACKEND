package com.example.demo.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Articulo;
import com.example.demo.entity.DetalleReceta;
import com.example.demo.entity.RubroArticulo;
import com.example.demo.repository.RubroArticuloRepository;
import com.example.demo.dtos.ArticuloDto;
import com.example.demo.dtos.DetalleRecetaDto;
import com.example.demo.dtos.InsumoDto;
import com.example.demo.dtos.RubroArticuloDto;
import com.example.demo.dtos.UnidadMedidaDto;

@Service
public class RubroArticuloServicio {


	RubroArticuloRepository repository;

	public RubroArticuloServicio(RubroArticuloRepository repository) {
		this.repository = repository;
	}
	
	public List<RubroArticuloDto> findAll() throws Exception {
		
		List<RubroArticulo>entities = repository.findAll();
		List<RubroArticuloDto>dtos = new ArrayList<RubroArticuloDto>();
		try {
			
			for(RubroArticulo entity : entities) {
				if(entity.getRubroParent() == null) { 
				RubroArticuloDto dto = new RubroArticuloDto();
				dto.setId(entity.getId());
				dto.setDenominacion(entity.getDenominacion());
				if(entity.getRubroChildren() != null) {
					setearHijos(entity,dto);	
				}			
				dtos.add(dto);
				}	
			}
			return dtos;
			
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	public void setearHijos(RubroArticulo rubro, RubroArticuloDto dto) {
		List<RubroArticuloDto>dtos = new ArrayList<RubroArticuloDto>();
	
		for(RubroArticulo rubroHijo : rubro.getRubroChildren()) {
			RubroArticuloDto dtoHijo = new RubroArticuloDto();
			dtoHijo.setId(rubroHijo.getId());
			dtoHijo.setDenominacion(rubroHijo.getDenominacion());
			dtos.add(dtoHijo);
			if(rubroHijo.getRubroChildren() != null) {
				setearHijos(rubroHijo,dtoHijo);
			}	
			
		}
		dto.setListRubrosHijos(dtos);
	}
	
public List<RubroArticuloDto> findAllSinAnidar() throws Exception {
		
		List<RubroArticulo>entities = repository.findAll();
		List<RubroArticuloDto>dtos = new ArrayList<RubroArticuloDto>();
		List<ArticuloDto>articulosDto = new ArrayList<ArticuloDto>();

		try {
			

			for(RubroArticulo entity : entities) {
				RubroArticuloDto dto = new RubroArticuloDto();
				dto.setId(entity.getId());
				dto.setDenominacion(entity.getDenominacion());
				for(Articulo articulo : entity.getArticuloList()) {
					ArticuloDto articuloDto = new ArticuloDto();
					articuloDto.setId(articulo.getId());
					articuloDto.setDenominacion(articulo.getDenominacion());
					articuloDto.setPrecioCompra(articulo.getPrecioCompra());
					articuloDto.setPrecioVenta(articulo.getPrecioVenta());
					articuloDto.setEsManufacturado(articulo.isEsManufacturado());
					articuloDto.setImagen(articulo.getImagen());
					
					 List<DetalleRecetaDto>detallesReceta = new ArrayList<DetalleRecetaDto>();
											
						for(DetalleReceta detalleReceta : articulo.getDetallesReceta()) {
							DetalleRecetaDto detalleRecetaDto = new DetalleRecetaDto();
							detalleRecetaDto.setId(detalleReceta.getId());
							detalleRecetaDto.setCantidad(detalleReceta.getCantidad());
							InsumoDto insumoDto = new InsumoDto();
							insumoDto.setId(detalleReceta.getInsumo().getId());
							insumoDto.setDenominacion(detalleReceta.getInsumo().getDenominacion());
							insumoDto.setPrecioCompra(detalleReceta.getInsumo().getPrecioCompra());
							insumoDto.setStockActual(detalleReceta.getInsumo().getStockActual());
							insumoDto.setStockMinimo(detalleReceta.getInsumo().getStockMinimo());
							UnidadMedidaDto unidadMedidaDto = new UnidadMedidaDto();
							unidadMedidaDto.setId(detalleReceta.getInsumo().getUnidadMedida().getId());
							unidadMedidaDto.setUnidadMedida(detalleReceta.getInsumo().getUnidadMedida().getUnidadMedida());
							insumoDto.setUnidadMedida(unidadMedidaDto);
							detalleRecetaDto.setInsumo(insumoDto);
							detallesReceta.add(detalleRecetaDto);
						}
						articuloDto.setDetalles(detallesReceta);	
						dto.getArticuloListDto().add(articuloDto);
				}
	
				dtos.add(dto);
			}
			return dtos;
			
			
		} catch (Exception e) {
			throw new Exception();
		}
		
	}
	
	public RubroArticuloDto findById(int id) throws Exception{
		
		Optional<RubroArticulo>entityOptional = repository.findById((long) id);
		
		RubroArticuloDto dto = new RubroArticuloDto();
		
		try {
			 RubroArticulo entity = entityOptional.get();
			
				dto.setId(entity.getId());
				dto.setDenominacion(entity.getDenominacion());
				//dto.setRubroArticulo(entity.getRubroArticulo());
		
		} catch (Exception e) {
			throw new Exception();
		}
		
		return dto;
	}
	
		
    public RubroArticuloDto save(RubroArticuloDto dto, boolean estado) throws Exception {
		
		RubroArticulo entity = new RubroArticulo();
		
		entity.setDenominacion(dto.getDenominacion());
		if(dto.getIdrubroPadreDto() != 0L) {
			Optional<RubroArticulo>rubroArticuloOptional = repository.findById(dto.getIdrubroPadreDto());
			RubroArticulo rubroParent = rubroArticuloOptional.get();
			entity.setRubroParent(rubroParent);
		}
		
		
		try {
			entity = repository.save(entity);
			dto.setId(entity.getId());
			return dto;
		} catch (Exception e) {
			throw new Exception();	
		}
		
			
	}
	
	public RubroArticuloDto update(int id, RubroArticuloDto dto, boolean estado) throws Exception {
		Optional<RubroArticulo> optionalEntity = repository.findById((long) id);
		
		try {
			 RubroArticulo entity = optionalEntity.get();
			    entity.setId(id);
			    entity.setDenominacion(dto.getDenominacion());
				//entity.setRubroArticulo(dto.getRubroArticulo());
						 
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

