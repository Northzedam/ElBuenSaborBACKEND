package com.example.demo.entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
	public class DetalleFactura extends EntidadGenerica implements Serializable{
		private static final long serialVersionUID = 1L;
		
		@Column(name = "Id")
		private long id;
		
		@Column(name = "Cantidad")
		private int cantidad;
		
		@Column(name = "Subtotal")
		private double subtotal;
		
		@ManyToOne(cascade = CascadeType.PERSIST)
		@JoinColumn(name = "id_factura")
		private Factura factura;
		
		@ManyToOne(cascade = CascadeType.PERSIST)
		@JoinColumn(name = "id_articuloConsumo")
		private Articulo articulo;
		
		
		public DetalleFactura() {
			super();
		}

		
		
		public DetalleFactura(long id, int cantidad, double subtotal, Factura factura, Articulo articuloConsumo) {
			super();
			this.cantidad = cantidad;
			this.subtotal = subtotal;
			this.factura = factura;
			this.articulo = articuloConsumo;
		}
		
		public DetalleFactura(int cantidad, double subtotal, Factura factura, Articulo articuloConsumo) {
			super();
			this.cantidad = cantidad;
			this.subtotal = subtotal;
			this.factura = factura;
			this.articulo = articuloConsumo;
		}


		
		public DetalleFactura(int cantidad, double subtotal) {
			super();
			this.cantidad = cantidad;
			this.subtotal = subtotal;
		}
		
		public DetalleFactura(int cantidad, double subtotal, Factura factura) {
			super();
			this.cantidad = cantidad;
			this.subtotal = subtotal;
			this.factura = factura;
		}


		//GETTERS Y SETTERS ------------------------------------------------------------------------

		public long getId() {
			return id;
		}



		public void setId(long id) {
			this.id = id;
		}



		public int getCantidad() {
			return cantidad;
		}



		public void setCantidad(int cantidad) {
			this.cantidad = cantidad;
		}



		public double getSubtotal() {
			return subtotal;
		}



		public void setSubtotal(double subtotal) {
			this.subtotal = subtotal;
		}



		public Factura getFactura() {
			return factura;
		}



		public void setFactura(Factura factura) {
			this.factura = factura;
		}



		public Articulo getArticulo() {
			return articulo;
		}



		public void setArticulo(Articulo articulo) {
			this.articulo = articulo;
		}

		
		
	
	
		
		
}	