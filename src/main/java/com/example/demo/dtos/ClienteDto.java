package com.example.demo.dtos;

import java.util.ArrayList;
import java.util.List;

public class ClienteDto {
	
	
	
	private long id;
	
	
	private String nombre;
	
	
	private String apellido;
	
	
	private int telefono;
	
	
	private String email;

	
	private DomicilioDto domicilio;

	
	private List<PedidoDto> pedidoList = new ArrayList<PedidoDto>();


	//Constructores
	
	public ClienteDto() {
		//super();
	}



	public ClienteDto(long id,String nombre, String apellido, int telefono, String email, DomicilioDto domicilio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
		this.domicilio = domicilio;
	}

	//Getter&Setters

	public long getId() {
		return id;
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



	public DomicilioDto getDomicilio() {
		return domicilio;
	}



	public void setDomicilio(DomicilioDto domicilio) {
		this.domicilio = domicilio;
	}
	
		
	
	
	

}
