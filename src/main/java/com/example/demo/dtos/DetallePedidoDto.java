package com.example.demo.dtos;



import com.example.demo.dtos.ArticuloConsumoDto;
import com.example.demo.dtos.ArticuloManufacturadoDto;
import com.example.demo.dtos.PedidoDto;

public class DetallePedidoDto {
	
	private long id;

	
	private int cantidad;
	
	
	private double subtotal;
	
	
	private ArticuloConsumoDto articuloConsumo;
	
	
	private ArticuloManufacturadoDto articuloManufacturado;


	public DetallePedidoDto() {
		super();
	}


	public DetallePedidoDto(long id, int cantidad, double subtotal, ArticuloConsumoDto articuloConsumo,
			ArticuloManufacturadoDto articuloManufacturado) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.subtotal = subtotal;
		this.articuloConsumo = articuloConsumo;
		this.articuloManufacturado = articuloManufacturado;
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


	public ArticuloConsumoDto getArticuloConsumo() {
		return articuloConsumo;
	}


	public void setArticuloConsumo(ArticuloConsumoDto articuloConsumo) {
		this.articuloConsumo = articuloConsumo;
	}


	public ArticuloManufacturadoDto getArticuloManufacturado() {
		return articuloManufacturado;
	}


	public void setArticuloManufacturado(ArticuloManufacturadoDto articuloManufacturado) {
		this.articuloManufacturado = articuloManufacturado;
	}


	
}
