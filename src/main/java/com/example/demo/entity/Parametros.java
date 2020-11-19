package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Parametros extends EntidadGenerica implements Serializable{

	private static final long serialVersionUID = 1L;
	@Column(name = "Id")
	private long id;
	
	@Column(name = "cantidadCocineros")
	private int cantidadCocineros;

	public Parametros() {
		super();
	}

	public Parametros(long id, int cantidadCocineros) {
		super();
		this.id = id;
		this.cantidadCocineros = cantidadCocineros;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCantidadCocineros() {
		return cantidadCocineros;
	}

	public void setCantidadCocineros(int cantidadCocineros) {
		this.cantidadCocineros = cantidadCocineros;
	}
	
	
	
	
}
