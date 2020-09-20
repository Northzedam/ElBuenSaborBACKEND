package com.example.demo.dtos;



import com.example.demo.dtos.ArticuloConsumoDto;
import com.example.demo.dtos.ArticuloManufacturadoDto;
import com.example.demo.dtos.FacturaDto;

public class DetalleFacturaDto {
	
	
	
	private long id;
	
	
	private int cantidad;
	
	
	private int subtotal;
	
	
	private FacturaDto factura;
	
	
	private ArticuloConsumoDto articuloConsumo;
	
	
	private ArticuloManufacturadoDto articuloManufacturado;
	
	public DetalleFacturaDto() {
		super();
	}

	
	
	public DetalleFacturaDto(long id, int cantidad, int subtotal, FacturaDto factura, ArticuloConsumoDto articuloConsumo) {
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
	
	public DetalleFacturaDto(int cantidad, int subtotal, FacturaDto factura) {
		super();
		this.cantidad = cantidad;
		this.subtotal = subtotal;
		this.factura = factura;
	}

	
	
	//GETTERS Y SETTERS ------------------------------------------------------------------------
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

	public int getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}



	public FacturaDto getFactura() {
		return factura;
	}



	public void setFactura(FacturaDto factura) {
		this.factura = factura;
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
