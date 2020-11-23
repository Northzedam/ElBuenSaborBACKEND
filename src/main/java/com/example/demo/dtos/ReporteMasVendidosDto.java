package com.example.demo.dtos;
import java.util.Date;
import java.util.List;

public class ReporteMasVendidosDto {
	
	private String Denominacion;
	
	private int cantidad;
	
	private Date fechaDesde;
	
	private Date fechaHasta;
	
	// agregar ganancias por articulo en rango de fecha
	
	// agregar ganancias totales en rango de fecha
	

	public ReporteMasVendidosDto() {
		super();
	}



	public ReporteMasVendidosDto(String denominacion, int cantidad, Date fechaDesde, Date fechaHasta) {
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



	public Date getFechaDesde() {
		return fechaDesde;
	}



	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}



	public Date getFechaHasta() {
		return fechaHasta;
	}



	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}
	
	

}