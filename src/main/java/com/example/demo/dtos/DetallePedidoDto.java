package com.example.demo.dtos;



import com.example.demo.dtos.ArticuloConsumoDto;


public class DetallePedidoDto {
	
	private long id;

	
	private int cantidad;
	
	
	private double subtotal;
	
	
	private long articuloConsumoId;
	
	
	private ArticuloConsumoDto articuloConsumoDto;
	
	


	public DetallePedidoDto() {
		super();
	}


	public DetallePedidoDto(long id, int cantidad, double subtotal,long articuloConsumoId, ArticuloConsumoDto articuloConsumoDto
			) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.subtotal = subtotal;
		this.articuloConsumoId = articuloConsumoId;
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


	public long getArticuloConsumoId() {
		return articuloConsumoId;
	}


	public void setArticuloConsumoId(long articuloConsumoId) {
		this.articuloConsumoId = articuloConsumoId;
	}


	public ArticuloConsumoDto getArticuloConsumoDto() {
		return articuloConsumoDto;
	}


	public void setArticuloConsumoDto(ArticuloConsumoDto articuloConsumoDto) {
		this.articuloConsumoDto = articuloConsumoDto;
	}


	
}
