package com.example.demo.dtos;



import com.example.demo.dtos.DomicilioDto;

public class EmpleadoDto {
    
    private long id;
	
	
	private String nombre;
	
	
	private String apellido;
	
	
	private String cuil;
	
	
	
	private int telefono;
	
	
	private String email;

	
	private DomicilioDto domicilioDto;


	public EmpleadoDto() {
		super();
	}


	public EmpleadoDto(long id, String nombre, String apellido, String cuil, int telefono, String email,
			DomicilioDto domicilioDto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.cuil = cuil;
		this.telefono = telefono;
		this.email = email;
		this.domicilioDto = domicilioDto;
	}


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


	public String getCuil() {
		return cuil;
	}


	public void setCuil(String cuil) {
		this.cuil = cuil;
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


	
	
	
}
