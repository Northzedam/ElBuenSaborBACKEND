package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class RubroGeneral extends EntidadGenerica implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "denominacion")
	private String denominacion;

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
