package com.example.demo.dtos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;

import com.example.demo.dtos.ArticuloManufacturadoDto;

public class RubroGeneralDto {
	
	private long id;
	
	
	private String denominacion;

	
	private List<ArticuloManufacturadoDto> articuloManufacturadoListDto = new ArrayList<ArticuloManufacturadoDto>();


	public RubroGeneralDto() {
		super();
	}


	public RubroGeneralDto(long id, String denominacion, List<ArticuloManufacturadoDto> articuloManufacturadoListDto) {
		super();
		this.id = id;
		this.denominacion = denominacion;
		this.articuloManufacturadoListDto = articuloManufacturadoListDto;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getDenominacion() {
		return denominacion;
	}


	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}


	public List<ArticuloManufacturadoDto> getArticuloManufacturadoListDto() {
		return articuloManufacturadoListDto;
	}


	public void setArticuloManufacturadoListDto(List<ArticuloManufacturadoDto> articuloManufacturadoListDto) {
		this.articuloManufacturadoListDto = articuloManufacturadoListDto;
	}


	
	
	
	
}
