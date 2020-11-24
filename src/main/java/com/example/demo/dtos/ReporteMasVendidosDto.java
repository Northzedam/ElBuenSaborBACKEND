package com.example.demo.dtos;
import java.util.Date;
import java.util.List;

public class ReporteMasVendidosDto {
	
	private String Denominacion;
	
	private int cantidad;
	
	private String fechaDesde;
	
	private String fechaHasta;
	
	// agregar ganancias por articulo en rango de fecha
	
	// agregar ganancias totales en rango de fecha
	

	public ReporteMasVendidosDto() {
		super();
	}



	public ReporteMasVendidosDto(String denominacion, int cantidad, String fechaDesde, String fechaHasta) {
		super();
		Denominacion = denominacion;
		this.cantidad = cantidad;
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
	}



	public String getDenominacion() {
		return Denominacion;
	}



	public void setDenominacion(String denominacion) {
		Denominacion = denominacion;
	}



	public int getCantidad() {
		return cantidad;
	}



	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}



	public String getFechaDesde() {
		return fechaDesde;
	}



	public void setFechaDesde(String fechaDesde) {
		this.fechaDesde = fechaDesde;
	}



	public String getFechaHasta() {
		return fechaHasta;
	}



	public void setFechaHasta(String fechaHasta) {
		this.fechaHasta = fechaHasta;
	}
	
	

}
