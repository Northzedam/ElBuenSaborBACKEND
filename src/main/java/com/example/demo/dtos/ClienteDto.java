package com.example.demo.dtos;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dtos.DomicilioDto;
import com.example.demo.dtos.PedidoDto;


public class ClienteDto {
	
	
	
	private long id;
	
	
	private String nombre;
	
	
	private String apellido;
	
	
	private int telefono;
	
	
	private String email;

	
	private DomicilioDto domicilioDto;

	
	private List<PedidoDto> pedidoListDto = new ArrayList<PedidoDto>();


	//Constructores
	
	public ClienteDto() {
		//super();
	}



	public ClienteDto(long id,String nombre, String apellido, int telefono, String email, DomicilioDto domicilioDto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
		this.domicilioDto = domicilioDto;
	}

	//Getter&Setters

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
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



	public DomicilioDto getDomicilioDto() {
		return domicilioDto;
	}



	public void setDomicilioDto(DomicilioDto domicilioDto) {
		this.domicilioDto = domicilioDto;
	}



	public List<PedidoDto> getPedidoListDto() {
		return pedidoListDto;
	}



	public void setPedidoListDto(List<PedidoDto> pedidoListDto) {
		this.pedidoListDto = pedidoListDto;
	}






	
	

}
