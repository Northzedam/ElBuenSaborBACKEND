package com.example.demo.dtos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import com.example.demo.entity.DetalleFactura;
import com.example.demo.entity.Pedido;

public class FacturaDto {
	
	private long id;
	
	
	private Date Fecha;
	
	
	private int numero;

	
	private double montoDescuento;

	
	private double total;

	
	private String formaDePago;

	
	private String nroTarjeta;


	
	private List<DetalleFactura> detalles = new ArrayList<DetalleFactura>();

	
	private Pedido pedido;


	public FacturaDto() {
		super();
	}


	public FacturaDto(long id, Date fecha, int numero, double montoDescuento, double total, String formaDePago,
			String nroTarjeta, List<DetalleFactura> detalles, Pedido pedido) {
		super();
		this.id = id;
		Fecha = fecha;
		this.numero = numero;
		this.montoDescuento = montoDescuento;
		this.total = total;
		this.formaDePago = formaDePago;
		this.nroTarjeta = nroTarjeta;
		this.detalles = detalles;
		this.pedido = pedido;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Date getFecha() {
		return Fecha;
	}


	public void setFecha(Date fecha) {
		Fecha = fecha;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public double getMontoDescuento() {
		return montoDescuento;
	}


	public void setMontoDescuento(double montoDescuento) {
		this.montoDescuento = montoDescuento;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	public String getFormaDePago() {
		return formaDePago;
	}


	public void setFormaDePago(String formaDePago) {
		this.formaDePago = formaDePago;
	}


	public String getNroTarjeta() {
		return nroTarjeta;
	}


	public void setNroTarjeta(String nroTarjeta) {
		this.nroTarjeta = nroTarjeta;
	}


	public List<DetalleFactura> getDetalles() {
		return detalles;
	}


	public void setDetalles(List<DetalleFactura> detalles) {
		this.detalles = detalles;
	}


	public Pedido getPedido() {
		return pedido;
	}


	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	
	
}
