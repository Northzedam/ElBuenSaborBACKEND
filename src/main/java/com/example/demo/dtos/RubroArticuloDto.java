package com.example.demo.dtos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;

import com.example.demo.dtos.ArticuloConsumoDto;
import com.example.demo.dtos.RubroArticuloDto;

public class RubroArticuloDto {
	
	private long id;
	
	
	private String denominacion;
	
	
	private RubroArticuloDto rubroArticuloDto;
	
	
	private List<ArticuloConsumoDto> articuloConsumoListDto = new ArrayList<ArticuloConsumoDto>();


	public RubroArticuloDto() {
		super();
	}


	public RubroArticuloDto(long id, String denominacion, RubroArticuloDto rubroArticuloDto,
			List<ArticuloConsumoDto> articuloConsumoListDto) {
		super();
		this.id = id;
		this.denominacion = denominacion;
		this.rubroArticuloDto = rubroArticuloDto;
		this.articuloConsumoListDto = articuloConsumoListDto;
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


	public List<ArticuloConsumoDto> getArticuloConsumoListDto() {
		return articuloConsumoListDto;
	}


	public void setArticuloConsumoListDto(List<ArticuloConsumoDto> articuloConsumoListDto) {
		this.articuloConsumoListDto = articuloConsumoListDto;
	}


}
