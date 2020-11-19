package com.example.demo.dtos;

public class ParametrosDto {
	
	long id;
	int cantidadCocineros;
	
	
	public ParametrosDto() {
		super();
	}


	public ParametrosDto(long id, int cantidadCocineros) {
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
