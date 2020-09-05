
package com.example.dtos;

public class ConfiguracionDto {

	private static final long serialVersionUID = 1L;
	
	
	private long id;
	
	
	private String emailEmpresa;
	
	
	private int cantidadCocinero;

	
	public ConfiguracionDto() {
		//super();
	}


	public ConfiguracionDto(long id,String emailEmpresa, int cantidadCocinero) {
		super();
		this.emailEmpresa = emailEmpresa;
		this.cantidadCocinero = cantidadCocinero;
	}

	public long getId() {
		return id;
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
