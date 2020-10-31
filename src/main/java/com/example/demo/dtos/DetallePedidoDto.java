package com.example.demo.dtos;



import com.example.demo.dtos.ArticuloDto;


public class DetallePedidoDto {
	
	private long id;

	
	private int cantidad;
	
	
	private double subtotal;
	
	
	private ArticuloDto articuloDto;
	
	


	public DetallePedidoDto() {
		super();
	}




	public DetallePedidoDto(long id, int cantidad, double subtotal, ArticuloDto articuloDto) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.subtotal = subtotal;
		this.articuloDto = articuloDto;
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




	public ArticuloDto getArticuloDto() {
		return articuloDto;
	}




	public void setArticuloDto(ArticuloDto articuloDto) {
		this.articuloDto = articuloDto;
	}


	

	
}
