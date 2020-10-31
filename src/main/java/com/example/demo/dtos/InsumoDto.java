package com.example.demo.dtos;

public class InsumoDto {
	
	private long id;

	private String denominacion;
	
	private double precioCompra;
	
	private double StockActual;
	
	private double stockMinimo;
	
	private String unidadMedida;

	public InsumoDto() {
		super();
	}

	public InsumoDto(long id, String denominacion, double precioCompra, double stockActual, double stockMinimo,
			String unidadMedida) {
		super();
		this.id = id;
		this.denominacion = denominacion;
		this.precioCompra = precioCompra;
		StockActual = stockActual;
		this.stockMinimo = stockMinimo;
		this.unidadMedida = unidadMedida;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public double getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}

	public double getStockActual() {
		return StockActual;
	}

	public void setStockActual(double stockActual) {
		StockActual = stockActual;
	}

	public double getStockMinimo() {
		return stockMinimo;
	}

	public void setStockMinimo(double stockMinimo) {
		this.stockMinimo = stockMinimo;
	}

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	
	
}
