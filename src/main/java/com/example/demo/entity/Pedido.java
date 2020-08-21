package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Pedido extends EntidadGenerica implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "Fecha")
	private Date fecha;
	
	@Column(name = "Numero")
	private int numero;
	
	@Column(name = "Estado")
	private String estado;

	@Column(name = "HoraFin")
	private Date horaFin;
	
	@Column(name = "TipoDeEnvio")
	private int tipoEnvio;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="cliente_id")
	private Cliente cliente;

	
	@OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name="Factura_id")
	private Factura factura;

	
	
	public Pedido() {
		super();
	}


	public Pedido(Date fecha, int numero, String estado, Date horaFin, int tipoEnvio, Cliente cliente, Factura factura) {
		super();
		this.fecha = fecha;
		this.numero = numero;
		this.estado = estado;
		this.horaFin = horaFin;
		this.tipoEnvio = tipoEnvio;
		this.cliente = cliente;
		this.factura = factura;
	}


	//SETTERS Y GETTERS
	
	public Factura getFactura() {
		return factura;
	}


	public void setFactura(Factura factura) {
		this.factura = factura;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public Date getHoraFin() {
		return horaFin;
	}


	public void setHoraFin(Date horaFin) {
		this.horaFin = horaFin;
	}


	public int getTipoEnvio() {
		return tipoEnvio;
	}


	public void setTipoEnvio(int tipoEnvio) {
		this.tipoEnvio = tipoEnvio;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
	
	
	

	

	
}
