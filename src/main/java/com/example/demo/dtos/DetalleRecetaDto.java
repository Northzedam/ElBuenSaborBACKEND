package com.example.demo.dtos;

public class DetalleRecetaDto {
	
	private long id;
	
	private double cantidad;
	
	private InsumoDto insumo;
	
	private long insumoId; // este atributo facilita el seteo del insumo en el servicio de Articulo
	
	private ArticuloDto articulo;

	public DetalleRecetaDto() {
		super();
	}

	

	public DetalleRecetaDto(long id, double cantidad, InsumoDto insumo, long insumoId, ArticuloDto articulo) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.insumo = insumo;
		this.insumoId = insumoId;
		this.articulo = articulo;
	}



	public long getInsumoId() {
		return insumoId;
	}


	public void setInsumoId(long insumoId) {
		this.insumoId = insumoId;
	}


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

	public InsumoDto getInsumo() {
		return insumo;
	}

	public void setInsumo(InsumoDto insumo) {
		this.insumo = insumo;
	}
	
	
	public ArticuloDto getArticulo() {
		return articulo;
	}

	public void setArticulo(ArticuloDto articulo) {
		this.articulo = articulo;
	}

	
	
}
