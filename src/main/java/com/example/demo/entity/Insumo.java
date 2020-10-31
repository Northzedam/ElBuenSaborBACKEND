package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Insumo extends EntidadGenerica implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "Denominacion")
	private String denominacion;
	
	@Column(name = "PrecioCompra")
	private double precioCompra;
	
	@Column(name = "StockActual")
	private double StockActual;
	
	@Column(name = "StockMinimo")
	private double stockMinimo;
	
	@Column(name = "UnidadMedida")
	private String unidadMedida;

	public Insumo() {
		super();
	}

	public Insumo(String denominacion, double precioCompra, double stockActual, double stockMinimo,
			String unidadMedida) {
		super();
		this.denominacion = denominacion;
		this.precioCompra = precioCompra;
		StockActual = stockActual;
		this.stockMinimo = stockMinimo;
		this.unidadMedida = unidadMedida;
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
