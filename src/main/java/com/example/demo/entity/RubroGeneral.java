package com.example.demo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class RubroGeneral extends EntidadGenerica implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "denominacion")
	private String denominacion;

	@OneToMany(mappedBy="rubroGeneral", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<ArticuloManufacturado> articuloManufacturadoList = new ArrayList<ArticuloManufacturado>();
	
	public RubroGeneral() {
		//super();
	}

	public RubroGeneral(String denominacion) {
		super();
		this.denominacion = denominacion;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}
	
	
}
