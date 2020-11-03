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
	
	
	private RubroArticuloDto rubroArticuloDto;
	
	
	private List<ArticuloDto> articuloListDto = new ArrayList<ArticuloDto>();


	public RubroArticuloDto() {
		super();
	}


	public RubroArticuloDto(long id, String denominacion, RubroArticuloDto rubroArticuloDto,
			List<ArticuloDto> articuloConsumoListDto) {
		super();
		this.id = id;
		this.denominacion = denominacion;
		this.rubroArticuloDto = rubroArticuloDto;
		this.articuloListDto = articuloConsumoListDto;
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


	public RubroArticuloDto getRubroArticuloDto() {
		return rubroArticuloDto;
	}


	public void setRubroArticuloDto(RubroArticuloDto rubroArticuloDto) {
		this.rubroArticuloDto = rubroArticuloDto;
	}


	public List<ArticuloDto> getArticuloConsumoListDto() {
		return articuloListDto;
	}


	public void setArticuloConsumoListDto(List<ArticuloDto> articuloConsumoListDto) {
		this.articuloListDto = articuloConsumoListDto;
	}


}
