package com.example.demo.dtos;



import com.example.demo.dtos.ArticuloConsumoDto;
import com.example.demo.dtos.ArticuloManufacturadoDto;

public class DetallePedidoDto {
	
	private long id;

	
	private int cantidad;
	
	
	private double subtotal;
	
	
	private ArticuloConsumoDto articuloConsumoDto;
	
	
	private ArticuloManufacturadoDto articuloManufacturadoDto;


	public DetallePedidoDto() {
		super();
	}


	public DetallePedidoDto(long id, int cantidad, double subtotal, ArticuloConsumoDto articuloConsumoDto,
			ArticuloManufacturadoDto articuloManufacturadoDto) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.subtotal = subtotal;
		this.articuloConsumoDto = articuloConsumoDto;
		this.articuloManufacturadoDto = articuloManufacturadoDto;
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


	public ArticuloManufacturadoDto getArticuloManufacturadoDto() {
		return articuloManufacturadoDto;
	}


	public void setArticuloManufacturadoDto(ArticuloManufacturadoDto articuloManufacturadoDto) {
		this.articuloManufacturadoDto = articuloManufacturadoDto;
	}

	
}
