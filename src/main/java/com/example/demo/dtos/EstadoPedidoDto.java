package com.example.demo.dtos;

public class EstadoPedidoDto {
	
	private long id;
	private String estadoPedido;
	
	public EstadoPedidoDto() {
		super();
	}

	public EstadoPedidoDto(long id, String estadoPedido) {
		super();
		this.id = id;
		this.estadoPedido = estadoPedido;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEstadoPedido() {
		return estadoPedido;
	}

	public void setEstadoPedido(String estadoPedido) {
		this.estadoPedido = estadoPedido;
	}
	
	

}
