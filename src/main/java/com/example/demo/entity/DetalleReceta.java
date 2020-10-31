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
public class DetalleReceta extends EntidadGenerica implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "Cantidad")
	private double cantidad;
	
	@OneToOne
	private Insumo insumo;
	
	/*@ManyToOne
    @JoinColumn(name = "articulo_id")
	private Articulo articulo;*/

	public DetalleReceta() {
		super();
	}

	public DetalleReceta(double cantidad, Insumo insumo) {
		super();
		this.cantidad = cantidad;
		this.insumo = insumo;
		
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public Insumo getInsumo() {
		return insumo;
	}

	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}

	
	
	
}
