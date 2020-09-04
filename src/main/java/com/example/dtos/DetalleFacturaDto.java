package com.example.dtos;



import com.example.demo.entity.ArticuloConsumo;
import com.example.demo.entity.ArticuloManufacturado;
import com.example.demo.entity.Factura;

public class DetalleFacturaDto {
	
	
	
	private long id;
	
	
	private int cantidad;
	
	
	private int subtotal;
	
	
	private Factura factura;
	
	
	private ArticuloConsumo articuloConsumo;
	
	
	private ArticuloManufacturado articuloManufacturado;
	
	public DetalleFacturaDto() {
		super();
	}

	
	
	public DetalleFacturaDto(long id, int cantidad, int subtotal, Factura factura, ArticuloConsumo articuloConsumo) {
		super();
		this.cantidad = cantidad;
		this.subtotal = subtotal;
		this.factura = factura;
		this.articuloConsumo = articuloConsumo;
	}


	
	public DetalleFacturaDto(int cantidad, int subtotal) {
		super();
		this.cantidad = cantidad;
		this.subtotal = subtotal;
	}
	
	public DetalleFacturaDto(int cantidad, int subtotal, Factura factura) {
		super();
		this.cantidad = cantidad;
		this.subtotal = subtotal;
		this.factura = factura;
	}

	
	
	//GETTERS Y SETTERS ------------------------------------------------------------------------
	public long getId() {
		return id;
	}
	
	public ArticuloConsumo getArticuloConsumo() {
		return articuloConsumo;
	}



	public void setArticuloConsumo(ArticuloConsumo articuloConsumo) {
		this.articuloConsumo = articuloConsumo;
	}



	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}
}
