package com.example.demo.dtos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import com.example.demo.entity.Cliente;
import com.example.demo.entity.DetallePedido;
import com.example.demo.entity.Factura;

public class PedidoDto {
	
	private long id;
	
	
	private Date fecha;
	
	
	private int numero;
	
	
	private String estado;

	
	private Date horaFin;
	
	
	private int tipoEnvio;

	
	private List<DetallePedido> detalles = new ArrayList<DetallePedido>();

	
	private Cliente cliente;
	
	
	private Factura factura;


	public PedidoDto() {
		super();
	}


	public PedidoDto(long id, Date fecha, int numero, String estado, Date horaFin, int tipoEnvio,
			List<DetallePedido> detalles, Cliente cliente, Factura factura) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.numero = numero;
		this.estado = estado;
		this.horaFin = horaFin;
		this.tipoEnvio = tipoEnvio;
		this.detalles = detalles;
		this.cliente = cliente;
		this.factura = factura;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
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


	public List<DetallePedido> getDetalles() {
		return detalles;
	}


	public void setDetalles(List<DetallePedido> detalles) {
		this.detalles = detalles;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Factura getFactura() {
		return factura;
	}


	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	
	
	
	
}
