package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class EstadoPedido extends EntidadGenerica implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String estadoPedido;
	
	public EstadoPedido() {
		super();
	}

	public EstadoPedido(long id, String estadoPedido) {
		super();
		this.id = id;
		this.estadoPedido = estadoPedido;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEstadoPedido() {
		return estadoPedido;
	}

	public void setEstadoPedido(String estadoPedido) {
		this.estadoPedido = estadoPedido;
	}
	
	
}
