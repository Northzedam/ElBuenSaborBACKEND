package com.example.demo.dtos;



import com.example.demo.dtos.ArticuloDto;
import com.example.demo.dtos.FacturaDto;

public class DetalleFacturaDto {
	
	
	
	private long id;	
	
	private int cantidad;	
	
	private double subtotal;	
	
	private FacturaDto facturaDto;	
	
	private ArticuloDto articuloDto;
	
	public DetalleFacturaDto() {
		super();
	}

	
	
	public DetalleFacturaDto(long id, int cantidad, double subtotal, FacturaDto facturaDto, ArticuloDto articuloDto) {
		super();
		this.cantidad = cantidad;
		this.subtotal = subtotal;
		this.facturaDto = facturaDto;
		this.articuloDto = articuloDto;
	}


	
	public DetalleFacturaDto(int cantidad, double subtotal) {
		super();
		this.cantidad = cantidad;
		this.subtotal = subtotal;
	}
	
	public DetalleFacturaDto(int cantidad, double subtotal, FacturaDto facturaDto) {
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

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}



	public FacturaDto getFacturaDto() {
		return facturaDto;
	}



	public void setFacturaDto(FacturaDto facturaDto) {
		this.facturaDto = facturaDto;
	}



	public ArticuloDto getArticuloDto() {
		return articuloDto;
	}



	public void setArticuloConsumoDto(ArticuloDto articuloDto) {
		this.articuloDto = articuloDto;
	}




}
