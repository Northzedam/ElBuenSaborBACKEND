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
	public class RubroArticulo implements Serializable{
		
	
		private static final long serialVersionUID = 1L;
		@Column(name = "Id")
		private long id;
		
		@Column(name = "Denominacion")
		private String denominacion;
		
		@Column(name = "Rubro")
		private RubroArticulo rubroArticulo;
		
		@OneToMany(mappedBy="rubroArticulo" ,cascade = CascadeType.ALL, orphanRemoval=true)
		@Column(name = "articulo_consumo")
		private List<ArticuloConsumo> articuloConsumoList = new ArrayList<ArticuloConsumo>();
		
		
		
		
		
		public RubroArticulo() {
			super();
		}

		public RubroArticulo(long id, String denominacion, RubroArticulo rubroArticulo, List<ArticuloConsumo> articuloConsumoList) {
			super();
			this.id = id;
			this.denominacion = denominacion;
			this.rubroArticulo = rubroArticulo;
			this.articuloConsumoList = articuloConsumoList;
		}



		public RubroArticulo(long id, String denominacion, RubroArticulo rubroArticulo) {
			super();
			this.id = id;
			this.denominacion = denominacion;
			this.rubroArticulo = rubroArticulo;
		}

	
		//GETTERS AND SETTERS
	
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public List<ArticuloConsumo> getArticuloConsumoList() {
			return articuloConsumoList;
		}

		public void setArticuloConsumoList(List<ArticuloConsumo> articuloConsumoList) {
			this.articuloConsumoList = articuloConsumoList;
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
		
		
		
}
