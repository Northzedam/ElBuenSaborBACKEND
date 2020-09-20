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
	public class DetalleFactura implements Serializable{
		private static final long serialVersionUID = 1L;
		
		@Column(name = "Id")
		private long id;
		
		@Column(name = "Cantidad")
		private int cantidad;
		
		@Column(name = "Subtotal")
		private int subtotal;
		
		@ManyToOne(cascade = CascadeType.PERSIST)
		@JoinColumn(name = "id_factura")
		private Factura factura;
		
		@ManyToOne(cascade = CascadeType.PERSIST)
		@JoinColumn(name = "id_articuloConsumo")
		private ArticuloConsumo articuloConsumo;
		
		@ManyToOne(cascade = CascadeType.PERSIST)
		@JoinColumn(name ="detalleFactura")
		private ArticuloManufacturado articuloManufacturado;
		
		public DetalleFactura() {
			super();
		}

		
		
		public DetalleFactura(long id, int cantidad, int subtotal, Factura factura, ArticuloConsumo articuloConsumo) {
			super();
			this.cantidad = cantidad;
			this.subtotal = subtotal;
			this.factura = factura;
			this.articuloConsumo = articuloConsumo;
		}


		
		public DetalleFactura(int cantidad, int subtotal) {
			super();
			this.cantidad = cantidad;
			this.subtotal = subtotal;
		}
		
		public DetalleFactura(int cantidad, int subtotal, Factura factura) {
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

		
		
		public ArticuloConsumo getArticuloConsumo() {
			return articuloConsumo;
		}


		public void setArticuloConsumo(ArticuloConsumo articuloConsumo) {
			this.articuloConsumo = articuloConsumo;
		}



		public Factura getFactura() {
			return factura;
		}

		public void setFactura(Factura factura) {
			this.factura = factura;
		}

		public int getCantidad() {
			return cantidad;
		}

		public void setCantidad(int cantidad) {
			this.cantidad = cantidad;
		}

		public int getSubtotal() {
			return subtotal;
		}

		public void setSubtotal(int subtotal) {
			this.subtotal = subtotal;
		}



		public ArticuloManufacturado getArticuloManufacturado() {
			return articuloManufacturado;
		}



		public void setArticuloManufacturado(ArticuloManufacturado articuloManufacturado) {
			this.articuloManufacturado = articuloManufacturado;
		}
		
		
		
}	