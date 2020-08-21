package com.example.demo.entity;
	
import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
	public class RubroArticulo extends EntidadGenerica implements Serializable{
		
	
		private static final long serialVersionUID = 1L;
		
		@Column(name = "Denominacion")
		private String denominacion;
		
		@Column(name = "Rubro")
		private RubroArticulo rubroArticulo;

		public RubroArticulo() {
			super();
		}

		public RubroArticulo(String denominacion, RubroArticulo rubroArticulo) {
			super();
			this.denominacion = denominacion;
			this.rubroArticulo = rubroArticulo;
		}

		
		
		
		//GETTERS AND SETTERS
		
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
