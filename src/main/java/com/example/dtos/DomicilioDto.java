
package com.example.dtos;

public class DomicilioDto {
	
	
	private long id;
	
	private String calle;
	
	private int numero;
	
	private String localidad;
	
	private String departamento;
	

	public DomicilioDto() {
		//super();
	}


	public DomicilioDto(long id, String calle, int numero, String localidad, String departamento) {
		super();
		this.id = id;
		this.calle = calle;
		this.numero = numero;
		this.localidad = localidad;
		this.departamento = departamento;
	}

	public long getId() {
		return id;
	}
	
	public String getCalle() {
		return calle;
	}


	public void setCalle(String calle) {
		this.calle = calle;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getLocalidad() {
		return localidad;
	}


	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}


	public String getDepartamento() {
		return departamento;
	}


	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	
	

}
