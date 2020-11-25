package com.example.demo.dtos;

import java.util.Date;
import java.util.HashMap;

public class ReporteGananciasDto {
	
	private Date fecha;
		
	private double monto;
	
    private String fechaDesde;
	
	private String fechaHasta;
	
	//private HashMap<String, Double> mapGananciasPorFecha = new HashMap<String,Double>();
	
	//private HashMap<String, Double> mapGananciasPorMes = new HashMap<String,Double>();


	public ReporteGananciasDto() {
		super();
	}


	public ReporteGananciasDto(Date fecha, double monto, String fechaDesde, String fechaHasta,
			HashMap<String, Double> mapGananciasPorFecha, HashMap<String, Double> mapGananciasPorMes) {
		super();
		this.fecha = fecha;
		this.monto = monto;
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
		//this.mapGananciasPorFecha = mapGananciasPorFecha;
		//this.mapGananciasPorMes = mapGananciasPorMes;
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


	/*public HashMap<String, Double> getMapGananciasPorFecha() {
		return mapGananciasPorFecha;
	}


	public void setMapGananciasPorFecha(HashMap<String, Double> mapGananciasPorFecha) {
		this.mapGananciasPorFecha = mapGananciasPorFecha;
	}


	public HashMap<String, Double> getMapGananciasPorMes() {
		return mapGananciasPorMes;
	}


	public void setMapGananciasPorMes(HashMap<String, Double> mapGananciasPorMes) {
		this.mapGananciasPorMes = mapGananciasPorMes;
	}
*/
	
	
	
	

}
