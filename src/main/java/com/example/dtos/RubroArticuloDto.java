package com.example.dtos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;

import com.example.demo.entity.ArticuloConsumo;
import com.example.demo.entity.RubroArticulo;

public class RubroArticuloDto {
	
	private long id;
	
	
	private String denominacion;
	
	
	private RubroArticulo rubroArticulo;
	
	
	private List<ArticuloConsumo> articuloConsumoList = new ArrayList<ArticuloConsumo>();


	public RubroArticuloDto() {
		super();
	}


	public RubroArticuloDto(long id, String denominacion, RubroArticulo rubroArticulo,
			List<ArticuloConsumo> articuloConsumoList) {
		super();
		this.id = id;
		this.denominacion = denominacion;
		this.rubroArticulo = rubroArticulo;
		this.articuloConsumoList = articuloConsumoList;
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


	public RubroArticulo getRubroArticulo() {
		return rubroArticulo;
	}


	public void setRubroArticulo(RubroArticulo rubroArticulo) {
		this.rubroArticulo = rubroArticulo;
	}


	public List<ArticuloConsumo> getArticuloConsumoList() {
		return articuloConsumoList;
	}


	public void setArticuloConsumoList(List<ArticuloConsumo> articuloConsumoList) {
		this.articuloConsumoList = articuloConsumoList;
	}
	
	
}
