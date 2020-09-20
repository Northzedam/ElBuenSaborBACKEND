package com.example.demo.entity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

@Entity
public class Cliente  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Column(name = "Id")
	private long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido")
	private String apellido;
	
	@Column(name = "telefono")
	private int telefono;
	
	@Column(name = "email")
	private String email;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="domicilio_id")
	private Domicilio domicilio;

	@OneToMany(mappedBy="cliente", cascade=CascadeType.ALL, orphanRemoval=true)
	@Column(name = "pedido")
	private List<Pedido> pedidoList = new ArrayList<Pedido>();


	//Constructores
	
	public Cliente() {
		//super();
	}



	public Cliente(long id,String nombre, String apellido, int telefono, String email, Domicilio domicilio) {
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



	public void setId(long id) {
		this.id = id;
	}



	public List<Pedido> getPedidoList() {
		return pedidoList;
	}



	public void setPedidoList(List<Pedido> pedidoList) {
		this.pedidoList = pedidoList;
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



	public Domicilio getDomicilio() {
		return domicilio;
	}



	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}
	
		
	
	
	

}
