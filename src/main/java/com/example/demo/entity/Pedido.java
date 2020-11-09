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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Pedido extends EntidadGenerica implements Serializable{
	private static final long serialVersionUID = 1L;
	@Column(name = "Id")
	private long id;
	
	@Column(name = "Fecha")
	private Date fecha;
	
	@Column(name = "Numero")
	private int numero;
	
	@Column(name = "Estado")
	private String estado;

	@Column(name = "tiempoRequerido")
	private int tiempoRequerido;
	
	@Column(name = "horaFin")
	private Date horaFin;

	
	@Column(name = "ConEnvio")
	private boolean conEnvio;
	
	@Column(name = "FechaAnulado")
	private Date fechaAnulado;
	
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
	@Column(name = "DetallePedido")
	private List<DetallePedido> detalles = new ArrayList<DetallePedido>();

	@JsonManagedReference
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "fk_factura")
	private Factura factura;
	
	@ManyToOne (cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_estadoPedido")
	private EstadoPedido estadoPedido;
	
	public Pedido() {
		super();
	}



	public Pedido(long id, Date fecha, int numero, String estado, Date horaFin, int tiempoRequerido, boolean conEnvio) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.numero = numero;
		this.estado = estado;
		this.tiempoRequerido = tiempoRequerido;
		this.horaFin = horaFin;
		this.conEnvio = conEnvio;
	}
	
	



	public Pedido(long id, Date fecha, int numero, String estado, int tiempoRequerido, Date horaFin, boolean conEnvio, List<DetallePedido> detalles) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.numero = numero;
		this.estado = estado;
		this.tiempoRequerido = tiempoRequerido;
		this.horaFin = horaFin;
		this.conEnvio = conEnvio;
		this.detalles = detalles;
	}
	
	
	public Pedido(long id, Date fecha, int numero, String estado, Date horaFin, boolean conEnvio, Date fechaAnulado,
			List<DetallePedido> detalles, Cliente cliente, Factura factura, EstadoPedido estadoPedido) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.numero = numero;
		this.estado = estado;
		this.horaFin = horaFin;
		this.conEnvio = conEnvio;
		this.fechaAnulado = fechaAnulado;
		this.detalles = detalles;
		this.cliente = cliente;
		this.factura = factura;
		this.estadoPedido = estadoPedido;
	}


	//SETTERS Y GETTERS


	public Factura getFactura() {
		return factura;
	}


	public void setFactura(Factura factura) {
		this.factura = factura;
	}


	public long getId() {
		return id;
	}
	
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


	public int getTiempoRequerido() {
		return tiempoRequerido;
	}


	public void setTiempoRequerido(int tiempoRequerido) {
		this.tiempoRequerido = tiempoRequerido;
	}


	public boolean getConEnvio() {
		return conEnvio;
	}


	public void setConEnvio(boolean conEnvio) {
		this.conEnvio = conEnvio;
	}


	public EstadoPedido getEstadoPedido() {
		return estadoPedido;
	}


	public void setEstadoPedido(EstadoPedido estadoPedido) {
		this.estadoPedido = estadoPedido;
	}


	public Date getFechaAnulado() {
		return fechaAnulado;
	}


	public void setFechaAnulado(Date fechaAnulado) {
		this.fechaAnulado = fechaAnulado;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public Date getHoraFin() {
		return horaFin;
	}



	public void setHoraFin(Date horaFin) {
		this.horaFin = horaFin;
	}


	
	
	
	
	
	
	

	

	
}
