package com.example.demo.entity;
	
import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

	public class ArticuloConsumo extends EntidadGenerica implements Serializable{
		
	
		private static final long serialVersionUID = 1L;

		@Column(name = "Denominacion")
		private String denominacion;
		
		@Column(name = "PrecioCompra")
		private double precioCompra;
		
		@Column(name = "PrecioVeta")
		private double precioVenta;
		
		@Column(name = "StockActual")
		private double stockActual;
		
		@Column(name = "stockMinimo")
		private double stockMinimo;
		
		@Column(name = "UnidadMedida")
		private String unidadMedida;
		
		@Column(name = "EsInsumo")
		private boolean esInsumo;
		
		@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
		@JoinColumn(name="Rubro")
		private RubroArticulo rubroArticulo;
		
		@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
		@JoinColumn(name="ArticuloManufacturadoDetalle")
		private ArticuloManufacturadoDetalle articuloManufacturadoDetalle;
		
		

		public ArticuloConsumo() {
			super();
		}

		public ArticuloConsumo(String denominacion, double precioCompra, double precioVenta, double stockActual,
				double stockMinimo, String unidadMedida, boolean esInsumo, RubroArticulo rubroArticulo,
				ArticuloManufacturadoDetalle articuloManufacturadoDetalle) {
			super();
			this.denominacion = denominacion;
			this.precioCompra = precioCompra;
			this.precioVenta = precioVenta;
			this.stockActual = stockActual;
			this.stockMinimo = stockMinimo;
			this.unidadMedida = unidadMedida;
			this.esInsumo = esInsumo;
			this.rubroArticulo = rubroArticulo;
			this.articuloManufacturadoDetalle = articuloManufacturadoDetalle;
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

		public double getStockActual() {
			return stockActual;
		}

		public void setStockActual(double stockActual) {
			this.stockActual = stockActual;
		}

		public double getStockMinimo() {
			return stockMinimo;
		}

		public void setStockMinimo(double stockMinimo) {
			this.stockMinimo = stockMinimo;
		}

		public String getUnidadMedida() {
			return unidadMedida;
		}

		public void setUnidadMedida(String unidadMedida) {
			this.unidadMedida = unidadMedida;
		}

		public boolean isEsInsumo() {
			return esInsumo;
		}

		public void setEsInsumo(boolean esInsumo) {
			this.esInsumo = esInsumo;
		}

		public RubroArticulo getRubroArticulo() {
			return rubroArticulo;
		}

		public void setRubroArticulo(RubroArticulo rubroArticulo) {
			this.rubroArticulo = rubroArticulo;
		}

		public ArticuloManufacturadoDetalle getArticuloManufacturadoDetalle() {
			return articuloManufacturadoDetalle;
		}

		public void setArticuloManufacturadoDetalle(ArticuloManufacturadoDetalle articuloManufacturadoDetalle) {
			this.articuloManufacturadoDetalle = articuloManufacturadoDetalle;
		}
		
		
		
		
		
   }	