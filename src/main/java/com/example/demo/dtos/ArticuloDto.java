package com.example.demo.dtos;

import java.util.List;

public class ArticuloDto {
	
	private long id;

	private String denominacion;
	
	private double precioCompra;
	
	private double precioVenta;
	
	private boolean esManufacturado;
	
	private String imagen;

	private List<DetalleRecetaDto>detalles;
	
	private int tiempoCocina;

	public ArticuloDto() {
		super();
	}

	public ArticuloDto(long id, String denominacion, double precioCompra, double precioVenta, boolean esManufacturado,
			String imagen) {
		super();
		this.id = id;
		this.denominacion = denominacion;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
		this.esManufacturado = esManufacturado;
		this.imagen = imagen;
		
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

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public boolean isEsManufacturado() {
		return esManufacturado;
	}

	public void setEsManufacturado(boolean esManufacturado) {
		this.esManufacturado = esManufacturado;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public List<DetalleRecetaDto> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleRecetaDto> detalles) {
		this.detalles = detalles;
	}

	public int getTiempoCocina() {
		return tiempoCocina;
	}

	public void setTiempoCocina(int tiempoCocina) {
		this.tiempoCocina = tiempoCocina;
	}

	
	
	
}
