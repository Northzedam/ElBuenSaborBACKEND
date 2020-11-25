package com.example.demo.dtos;

public class ReportePedidosPorClienteDto {
	
    private String nombre;
	
	private String apellido;
	
	private int telefono;
	
	private String email;

	private int cantidadPedidos;
	
	private double montoTotalGastado;
	
	

	public ReportePedidosPorClienteDto() {
		super();
	}



	public ReportePedidosPorClienteDto(String nombre, String apellido, int telefono, String email, int cantidadPedidos,
			double montoTotalGastado) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
		this.cantidadPedidos = cantidadPedidos;
		this.montoTotalGastado = montoTotalGastado;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public int getTelefono() {
		return telefono;
	}



	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public int getCantidadPedidos() {
		return cantidadPedidos;
	}



	public void setCantidadPedidos(int cantidadPedidos) {
		this.cantidadPedidos = cantidadPedidos;
	}



	public double getMontoTotalGastado() {
		return montoTotalGastado;
	}



	public void setMontoTotalGastado(double montoTotalGastado) {
		this.montoTotalGastado = montoTotalGastado;
	}
	
	
	
}
