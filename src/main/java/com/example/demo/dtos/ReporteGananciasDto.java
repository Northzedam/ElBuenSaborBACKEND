package com.example.demo.dtos;

import java.util.Date;

public class ReporteGananciasDto {
	
	private Date fecha;
		
	private double monto;
	
    private String fechaDesde;
	
	private String fechaHasta;

	public ReporteGananciasDto() {
		super();
	}

	public ReporteGananciasDto(Date fecha, double monto, String fechaDesde, String fechaHasta) {
		super();
		this.fecha = fecha;
		this.monto = monto;
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
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
