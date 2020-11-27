package com.example.demo.entity;
	
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
	public class Articulo extends EntidadGenerica implements Serializable{
		
	
		private static final long serialVersionUID = 1L;
		
		@Column(name = "Denominacion")
		private String denominacion;
		
		@Column(name = "PrecioCompra")
		private double precioCompra;
		
		@Column(name = "PrecioVenta")
		private double precioVenta;
		
		@Column(name = "EsManufacturado")
		private boolean esManufacturado;
		
		@Column(name = "TiempoEstimadoCocina")
		private int tiempoCocina;
		
		@OneToMany(cascade = CascadeType.ALL)
		@JoinColumn(name = "id_articulo")
		List<DetalleReceta>detallesReceta = new ArrayList<DetalleReceta>();
		
		@Column(name = "imagen")
		private String imagen;

		@ManyToOne
		@JoinColumn(name="rubroArticulo")
		private RubroArticulo rubroArticulo;
		
		public Articulo() {
			super();
		}


		public Articulo(String denominacion, double precioCompra, double precioVenta, boolean esManufacturado,
				int tiempoCocina, List<DetalleReceta> detallesReceta, String imagen, RubroArticulo rubroArticulo) {
			super();
			this.denominacion = denominacion;
			this.precioCompra = precioCompra;
			this.precioVenta = precioVenta;
			this.esManufacturado = esManufacturado;
			this.tiempoCocina = tiempoCocina;
			this.detallesReceta = detallesReceta;
			this.imagen = imagen;
			this.rubroArticulo = rubroArticulo;
		}



		public String getDenominacion() {
			return denominacion;
		}

		public void setDenominacion(String denominacion) {
			this.denominacion = denominacion;
		}

		public double getPrecioCompra() {
			return precioCompra;
		}

		public void setPrecioCompra(double precioCompra) {
			this.precioCompra = precioCompra;
		}

		public double getPrecioVenta() {
			return precioVenta;
		}

		public void setPrecioVenta(double precioVenta) {
			this.precioVenta = precioVenta;
		}

		public boolean isEsManufacturado() {
			return esManufacturado;
		}

		public void setEsManufacturado(boolean esManufacturado) {
			this.esManufacturado = esManufacturado;
		}

		public int getTiempoCocina() {
			return tiempoCocina;
		}

		public void setTiempoCocina(int tiempoCocina) {
			this.tiempoCocina = tiempoCocina;
		}

		public List<DetalleReceta> getDetallesReceta() {
			return detallesReceta;
		}

		public void setDetallesReceta(List<DetalleReceta> detallesReceta) {
			this.detallesReceta = detallesReceta;
		}

		public String getImagen() {
			return imagen;
		}

		public void setImagen(String imagen) {
			this.imagen = imagen;
		}

		public RubroArticulo getRubroArticulo() {
			return rubroArticulo;
		}

		public void setRubroArticulo(RubroArticulo rubroArticulo) {
			this.rubroArticulo = rubroArticulo;
		}
	
		
		
   }	