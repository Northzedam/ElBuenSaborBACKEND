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

		@Column(name = "Cantidad")
		private int cantidad;
		
		@Column(name = "Subtotal")
		private int subtotal;

		public DetalleFactura() {
			super();
		}

		public DetalleFactura(int cantidad, int subtotal) {
			super();
			this.cantidad = cantidad;
			this.subtotal = subtotal;
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
		
		
}	