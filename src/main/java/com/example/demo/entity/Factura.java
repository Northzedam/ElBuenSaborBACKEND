package com.example.demo.entity;
	
	import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
	public class Factura extends EntidadGenerica implements Serializable{
		private static final long serialVersionUID = 1L;

		@Column(name = "Fecha")
		private Date Fecha;
		
		@Column(name = "Numero")
		private int numero;

		@Column(name = "MontoDescuento")
		private double montoDescuento;

		@Column(name = "Total")
		private double total;

		@Column(name = "FormaDePago")
		private String formaDePago;

		@Column(name = "NTarjeta")
		private String nroTarjeta;


		@OneToMany(mappedBy="factura" ,cascade = CascadeType.ALL, orphanRemoval=true)
		@Column(name = "DetalleFactura")
		private List<DetalleFactura> detalles = new ArrayList<DetalleFactura>();

		@OneToOne(mappedBy="factura")
		private Pedido pedido;
		
		public Factura() {
			super();
		}

		public Factura(Date fecha, int numero, double montoDescuento, double total, String formaDePago,
				String nroTarjeta) {
			super();
			Fecha = fecha;
			this.numero = numero;
			this.montoDescuento = montoDescuento;
			this.total = total;
			this.formaDePago = formaDePago;
			this.nroTarjeta = nroTarjeta;
		}
		
		

		public Factura(Date fecha, int numero, double montoDescuento, double total, String formaDePago,
				String nroTarjeta, List<DetalleFactura> detalles) {
			super();
			Fecha = fecha;
			this.numero = numero;
			this.montoDescuento = montoDescuento;
			this.total = total;
			this.formaDePago = formaDePago;
			this.nroTarjeta = nroTarjeta;
			this.detalles = detalles;
		}
		
		

		//GETTERS Y SETTERS ------------------------------------------------------------------------
		
		public List<DetalleFactura> getDetalles() {
			return detalles;
		}

		public void setDetalles(List<DetalleFactura> detalles) {
			this.detalles = detalles;
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
		
		

		
	}