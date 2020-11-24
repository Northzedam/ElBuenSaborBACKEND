package com.example.demo.dtos;

import java.util.Date;

public class ReporteGananciasDto {
	
	private Date fecha;
	
	private String Mes;
	
	private double monto;

	public ReporteGananciasDto() {
		super();
	}

	public ReporteGananciasDto(Date fecha, String mes, double monto) {
		super();
		this.fecha = fecha;
		Mes = mes;
		this.monto = monto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getMes() {
		return Mes;
	}

	public void setMes(String mes) {
		Mes = mes;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}
	
	

}
