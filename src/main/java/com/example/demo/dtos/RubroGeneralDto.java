package com.example.demo.dtos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;

import com.example.demo.entity.ArticuloManufacturado;

public class RubroGeneralDto {
	
	private long id;
	
	
	private String denominacion;

	
	private List<ArticuloManufacturado> articuloManufacturadoList = new ArrayList<ArticuloManufacturado>();


	public RubroGeneralDto() {
		super();
	}


	public RubroGeneralDto(long id, String denominacion, List<ArticuloManufacturado> articuloManufacturadoList) {
		super();
		this.id = id;
		this.denominacion = denominacion;
		this.articuloManufacturadoList = articuloManufacturadoList;
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


	public List<ArticuloManufacturado> getArticuloManufacturadoList() {
		return articuloManufacturadoList;
	}


	public void setArticuloManufacturadoList(List<ArticuloManufacturado> articuloManufacturadoList) {
		this.articuloManufacturadoList = articuloManufacturadoList;
	}
	
	
	
	
}
