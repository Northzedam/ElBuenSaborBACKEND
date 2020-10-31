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
	public class DetallePedido extends EntidadGenerica implements Serializable{
		private static final long serialVersionUID = 1L;
		@Column(name = "Id")
		private long id;

		@Column(name = "Cantidad")
		private int cantidad;
		
		@Column(name = "Subtotal")
		private double subtotal;
		
		@ManyToOne(cascade = CascadeType.PERSIST)
		@JoinColumn(name = "id_articulo")
		private Articulo articulo;
		

		public DetallePedido() {
			super();
		}		
		
		public DetallePedido(long id, int cantidad, double subtotal, Articulo articulo) {
			super();
			this.id = id;
			this.cantidad = cantidad;
			this.subtotal = subtotal;
			this.articulo = articulo;
		}

		public DetallePedido(long id, int cantidad, double subtotal) {
			super();
			this.id = id;
			this.cantidad = cantidad;
			this.subtotal = subtotal;
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

		public Articulo EsManufacturado() {
			return articulo;
		}

		public void setArticulo(Articulo articulo) {
			this.articulo = articulo;
		}

		public Articulo getArticulo() {
			return articulo;
		}

		
	
		
}
