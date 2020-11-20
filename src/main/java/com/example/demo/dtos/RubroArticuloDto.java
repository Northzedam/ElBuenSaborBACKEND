package com.example.demo.dtos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;

import com.example.demo.dtos.ArticuloDto;
import com.example.demo.dtos.RubroArticuloDto;

public class RubroArticuloDto {
	
	private long id;
	
	
	private String denominacion;
	
	
	private long IdrubroPadreDto;
	
	private List<RubroArticuloDto>listRubrosHijos;
	
	private List<ArticuloDto> articuloListDto = new ArrayList<ArticuloDto>();


	public RubroArticuloDto() {
		super();
	}


	public RubroArticuloDto(long id, String denominacion, long idrubroPadreDto, List<RubroArticuloDto> listRubrosHijos,
			List<ArticuloDto> articuloListDto) {
		super();
		this.id = id;
		this.denominacion = denominacion;
		IdrubroPadreDto = idrubroPadreDto;
		this.listRubrosHijos = listRubrosHijos;
		this.articuloListDto = articuloListDto;
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


	public long getIdrubroPadreDto() {
		return IdrubroPadreDto;
	}


	public void setIdrubroPadreDto(long idrubroPadreDto) {
		IdrubroPadreDto = idrubroPadreDto;
	}


	public List<RubroArticuloDto> getListRubrosHijos() {
		return listRubrosHijos;
	}


	public void setListRubrosHijos(List<RubroArticuloDto> listRubrosHijos) {
		this.listRubrosHijos = listRubrosHijos;
	}


	public List<ArticuloDto> getArticuloListDto() {
		return articuloListDto;
	}


	public void setArticuloListDto(List<ArticuloDto> articuloListDto) {
		this.articuloListDto = articuloListDto;
	}


	

}
