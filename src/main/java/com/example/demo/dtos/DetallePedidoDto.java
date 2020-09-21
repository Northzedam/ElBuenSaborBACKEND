package com.example.demo.dtos;



import com.example.demo.entity.ArticuloConsumo;
import com.example.demo.entity.ArticuloManufacturado;
import com.example.demo.entity.Pedido;

public class DetallePedidoDto {
	
	private long id;

	
	private int cantidad;
	
	
	private double subtotal;
	
	
	private ArticuloConsumo articuloConsumo;
	
	
	private ArticuloManufacturado articuloManufacturado;


	public DetallePedidoDto() {
		super();
	}


	public DetallePedidoDto(long id, int cantidad, double subtotal, ArticuloConsumo articuloConsumo,
			ArticuloManufacturado articuloManufacturado) {
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


	public ArticuloConsumo getArticuloConsumo() {
		return articuloConsumo;
	}


	public void setArticuloConsumo(ArticuloConsumo articuloConsumo) {
		this.articuloConsumo = articuloConsumo;
	}


	public ArticuloManufacturado getArticuloManufacturado() {
		return articuloManufacturado;
	}


	public void setArticuloManufacturado(ArticuloManufacturado articuloManufacturado) {
		this.articuloManufacturado = articuloManufacturado;
	}

	
}
