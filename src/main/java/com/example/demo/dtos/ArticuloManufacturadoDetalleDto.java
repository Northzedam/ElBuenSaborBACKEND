
package com.example.demo.dtos;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class ArticuloManufacturadoDetalleDto  {

private static final long serialVersionUID = 1L;
	
	
	private long id;

	
	private double cantidad;
	
	
	private String unidadMedida;
	
	
	private ArticuloManufacturadoDto articuloManufacturado;
	
	
	private ArticuloConsumoDto articuloConsumo;
	
	

	//Constructores
	
	public ArticuloManufacturadoDetalleDto() {
		//super();
	}

	public ArticuloManufacturadoDetalleDto(long id,double cantidad, String unidadMedida,
			ArticuloManufacturadoDto articuloManufacturado 
			//,ArticuloConsumo articuloConsumo
			) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.unidadMedida = unidadMedida;
		this.articuloManufacturado = articuloManufacturado;
		//this.articuloConsumo = articuloConsumo;
	}

	//Getter & Setters
	public long getId() {
		return id;
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

	public ArticuloManufacturadoDto getArticuloManufacturado() {
		return articuloManufacturado;
	}

	public void setArticuloManufacturado(ArticuloManufacturadoDto articuloManufacturado) {
		this.articuloManufacturado = articuloManufacturado;
	}

	/*public ArticuloConsumo getArticuloConsumo() {
		return articuloConsumo;
	}

	public void setArticuloConsumo(ArticuloConsumo articuloConsumo) {
		this.articuloConsumo = articuloConsumo;
	}*/
	
	
	
	
	
}
