package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Configuracion extends EntidadGenerica implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "emailEmpresa")
	private String emailEmpresa;
	
	@Column(name = "cantidadCocinero")
	private int cantidadCocinero;

	
	public Configuracion() {
		super();
	}


	public Configuracion(String emailEmpresa, int cantidadCocinero) {
		super();
		this.emailEmpresa = emailEmpresa;
		this.cantidadCocinero = cantidadCocinero;
	}


	public String getEmailEmpresa() {
		return emailEmpresa;
	}


	public void setEmailEmpresa(String emailEmpresa) {
		this.emailEmpresa = emailEmpresa;
	}


	public int getCantidadCocinero() {
		return cantidadCocinero;
	}


	public void setCantidadCocinero(int cantidadCocinero) {
		this.cantidadCocinero = cantidadCocinero;
	}
	
	
}
