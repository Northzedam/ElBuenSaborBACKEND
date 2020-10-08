package com.example.demo.dtos;



import com.example.demo.dtos.ArticuloConsumoDto;
import com.example.demo.dtos.FacturaDto;

public class DetalleFacturaDto {
	
	
	
	private long id;
	
	
	private int cantidad;
	
	
	private int subtotal;
	
	
	private FacturaDto facturaDto;
	
	
	private ArticuloConsumoDto articuloConsumoDto;
	
	
	
	public DetalleFacturaDto() {
		super();
	}

	
	
	public DetalleFacturaDto(long id, int cantidad, int subtotal, FacturaDto facturaDto, ArticuloConsumoDto articuloConsumoDto) {
		super();
		this.cantidad = cantidad;
		this.subtotal = subtotal;
		this.facturaDto = facturaDto;
		this.articuloConsumoDto = articuloConsumoDto;
	}


	
	public DetalleFacturaDto(int cantidad, int subtotal) {
		super();
		this.cantidad = cantidad;
		this.subtotal = subtotal;
	}
	
	public DetalleFacturaDto(int cantidad, int subtotal, FacturaDto facturaDto) {
		super();
		this.cantidad = cantidad;
		this.subtotal = subtotal;
		this.facturaDto = facturaDto;
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



	public FacturaDto getFacturaDto() {
		return facturaDto;
	}



	public void setFacturaDto(FacturaDto facturaDto) {
		this.facturaDto = facturaDto;
	}



	public ArticuloConsumoDto getArticuloConsumoDto() {
		return articuloConsumoDto;
	}



	public void setArticuloConsumoDto(ArticuloConsumoDto articuloConsumoDto) {
		this.articuloConsumoDto = articuloConsumoDto;
	}




}
