package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ArticuloManufacturadoDetalle extends EntidadGenerica implements Serializable {

private static final long serialVersionUID = 1L;
	
	@Column(name = "cantidad")
	private double cantidad;
	
	@Column(name = "unidadMedida")
	private String unidadMedida;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="articuloManufacturado_id")
	private ArticuloManufacturado articuloManufacturado;
	
	/*@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="articuloConsumo_id")
	private ArticuloConsumo articuloConsumo;*/

	//Contructores
	
	public ArticuloManufacturadoDetalle() {
		super();
	}

	public ArticuloManufacturadoDetalle(double cantidad, String unidadMedida,
			ArticuloManufacturado articuloManufacturado 
			//,ArticuloConsumo articuloConsumo
			) {
		super();
		this.cantidad = cantidad;
		this.unidadMedida = unidadMedida;
		this.articuloManufacturado = articuloManufacturado;
		//this.articuloConsumo = articuloConsumo;
	}

	//Getter & Setters
	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public ArticuloManufacturado getArticuloManufacturado() {
		return articuloManufacturado;
	}

	public void setArticuloManufacturado(ArticuloManufacturado articuloManufacturado) {
		this.articuloManufacturado = articuloManufacturado;
	}

	/*public ArticuloConsumo getArticuloConsumo() {
		return articuloConsumo;
	}

	public void setArticuloConsumo(ArticuloConsumo articuloConsumo) {
		this.articuloConsumo = articuloConsumo;
	}*/
	
	
	
	
	
}
