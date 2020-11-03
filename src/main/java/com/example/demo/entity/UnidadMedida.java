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
public class UnidadMedida extends EntidadGenerica implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	@Column(name = "UnidadMedida")
	private String unidadMedida;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadMedida", orphanRemoval=true)
	List<Insumo>insumos = new ArrayList<Insumo>();

	public UnidadMedida() {
		super();
	}

	public UnidadMedida(String unidadMedida, List<Insumo> insumos) {
		super();
		this.unidadMedida = unidadMedida;
		this.insumos = insumos;
	}

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public List<Insumo> getInsumos() {
		return insumos;
	}

	public void setInsumos(List<Insumo> insumos) {
		this.insumos = insumos;
	}

	
	
}
