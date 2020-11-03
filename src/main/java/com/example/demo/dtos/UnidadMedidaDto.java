package com.example.demo.dtos;

public class UnidadMedidaDto {

	private long Id;
	
	private String unidadMedida;

	public UnidadMedidaDto() {
		super();
	}

	public UnidadMedidaDto(long id, String unidadMedida) {
		super();
		Id = id;
		this.unidadMedida = unidadMedida;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	
	
}
