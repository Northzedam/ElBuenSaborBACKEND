package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class ArticuloManufacturadoDetalle  implements Serializable {

private static final long serialVersionUID = 1L;
	
	@Column(name = "Id")
	private long id;

	@Column(name = "cantidad")
	private double cantidad;
	
	@Column(name = "unidadMedida")
	private String unidadMedida;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="articuloManufacturado_id")
	private ArticuloManufacturado articuloManufacturado;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="articuloConsumo_id")
	private ArticuloConsumo articuloConsumo;
	
	

	//Constructores
	
	public ArticuloManufacturadoDetalle() {
		//super();
	}

	public ArticuloManufacturadoDetalle(long id,double cantidad, String unidadMedida,
			ArticuloManufacturado articuloManufacturado 
			,ArticuloConsumo articuloConsumo
			) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.unidadMedida = unidadMedida;
		this.articuloManufacturado = articuloManufacturado;
		this.articuloConsumo = articuloConsumo;
	}

	//Getter & Setters
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public ArticuloConsumo getArticuloConsumo() {
		return articuloConsumo;
	}

	public void setArticuloConsumo(ArticuloConsumo articuloConsumo) {
		this.articuloConsumo = articuloConsumo;
	}
	
	
	
	
	
}
