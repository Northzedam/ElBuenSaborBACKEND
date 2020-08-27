package com.example.demo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

	@OneToMany(mappedBy="pedido" ,cascade = CascadeType.ALL, orphanRemoval=true)
	@Column(name = "DetallePedido")
	private List<DetallePedido> detalles = new ArrayList<DetallePedido>();

	
	
	public Pedido() {
		super();
	}


	public Pedido(Date fecha, int numero, String estado, Date horaFin, int tipoEnvio) {
		super();
		this.fecha = fecha;
		this.numero = numero;
		this.estado = estado;
		this.horaFin = horaFin;
		this.tipoEnvio = tipoEnvio;
	}
	
	


	public Pedido(Date fecha, int numero, String estado, Date horaFin, int tipoEnvio, List<DetallePedido> detalles) {
		super();
		this.fecha = fecha;
		this.numero = numero;
		this.estado = estado;
		this.horaFin = horaFin;
		this.tipoEnvio = tipoEnvio;
		this.detalles = detalles;
	}


	//SETTERS Y GETTERS


	
	
	public Date getFecha() {
		return fecha;
	}


	public List<DetallePedido> getDetalles() {
		return detalles;
	}


	public void setDetalles(List<DetallePedido> detalles) {
		this.detalles = detalles;
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


	
	
	
	
	
	
	

	

	
}
