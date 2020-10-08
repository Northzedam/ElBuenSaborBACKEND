package com.example.demo.dtos;



import com.example.demo.dtos.ArticuloConsumoDto;


public class DetallePedidoDto {
	
	private long id;

	
	private int cantidad;
	
	
	private double subtotal;
	
	
	private ArticuloConsumoDto articuloConsumoDto;
	
	


	public DetallePedidoDto() {
		super();
	}


	public DetallePedidoDto(long id, int cantidad, double subtotal, ArticuloConsumoDto articuloConsumoDto
			) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.subtotal = subtotal;
		this.articuloConsumoDto = articuloConsumoDto;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public double getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}


	public ArticuloConsumoDto getArticuloConsumoDto() {
		return articuloConsumoDto;
	}


	public void setArticuloConsumoDto(ArticuloConsumoDto articuloConsumoDto) {
		this.articuloConsumoDto = articuloConsumoDto;
	}


	
}
