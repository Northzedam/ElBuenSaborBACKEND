package com.example.demo.entity;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ArticuloManufacturado extends EntidadGenerica implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "tiempoEstimadoCocina")
	private int tiempoEstimadoCocina;
	
	@Column(name = "denominacion")
	private String denominacion;
	
	@Column(name = "precioVenta")
	private double precioVenta;
	
	/*@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="rubroGeneral_id")
	private RubroGeneral rubroGeneral;*/
	
	

		
	//Constructores
	
	public ArticuloManufacturado() {
		super();
	}


	public ArticuloManufacturado(int tiempoEstimadoCocina, String denominacion, double precioVenta) {
		super();
		this.tiempoEstimadoCocina = tiempoEstimadoCocina;
		this.denominacion = denominacion;
		this.precioVenta = precioVenta;
		
	}


	public int getTiempoEstimadoCocina() {
		return tiempoEstimadoCocina;
	}


	public void setTiempoEstimadoCocina(int tiempoEstimadoCocina) {
		this.tiempoEstimadoCocina = tiempoEstimadoCocina;
	}


	public String getDenominacion() {
		return denominacion;
	}


	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}


	public double getPrecioVenta() {
		return precioVenta;
	}


	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}


	/*public RubroGeneral getRubroGeneral() {
		return rubroGeneral;
	}


	public void setRubroGeneral(RubroGeneral rubroGeneral) {
		this.rubroGeneral = rubroGeneral;
	}
	*/

	
	
}
