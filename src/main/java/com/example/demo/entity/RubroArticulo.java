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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
	public class RubroArticulo extends EntidadGenerica implements Serializable{
		
	
		private static final long serialVersionUID = 1L;
		@Column(name = "Id")
		private long id;
		
		@Column(name = "Denominacion")
		private String denominacion;
		
		@Column(name = "Rubro")
		private RubroArticulo rubroArticulo;
		
		@OneToMany(mappedBy="rubroArticulo" ,cascade = CascadeType.ALL, orphanRemoval=true)
		@Column(name = "articulo")
		private List<Articulo> articuloList = new ArrayList<Articulo>();
	
		
		public RubroArticulo() {
			super();
		}


		public RubroArticulo(long id, String denominacion, RubroArticulo rubroArticulo,
				List<Articulo> articuloConsumoList) {
			super();
			this.id = id;
			this.denominacion = denominacion;
			this.rubroArticulo = rubroArticulo;
			this.articuloList = articuloConsumoList;
		}


		public long getId() {
			return id;
		}


		public void setId(long id) {
			this.id = id;
		}


		public String getDenominacion() {
			return denominacion;
		}


		public void setDenominacion(String denominacion) {
			this.denominacion = denominacion;
		}


		public RubroArticulo getRubroArticulo() {
			return rubroArticulo;
		}


		public void setRubroArticulo(RubroArticulo rubroArticulo) {
			this.rubroArticulo = rubroArticulo;
		}


		public List<Articulo> getArticuloList() {
			return articuloList;
		}


		public void setArticuloList(List<Articulo> articuloList) {
			this.articuloList = articuloList;
		}

		
		
		
		
		
}
