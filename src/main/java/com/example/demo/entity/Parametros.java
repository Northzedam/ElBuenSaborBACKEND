package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Parametros extends EntidadGenerica implements Serializable{

	private static final long serialVersionUID = 1L;
	@Column(name = "Id")
	private long id;
	
	@Column(name = "cantidadCocineros")
	private int cantidadCocineros;
	
	@Column(name = "horarioAperturaDiurno")
	private int horarioAperturaDiurno;
	
	@Column(name = "horarioClausuraDiurno")
	private int horarioClausuraDiurno;
	
	@Column(name = "horarioAperturaNocturno")
	private int horarioAperturaNocturno;
	
	@Column(name = "horarioClausuraNocturno")
	private int horarioClausuraNocturno;

	public Parametros() {
		super();
	}

	public Parametros(long id, int cantidadCocineros, int horarioAperturaDiurno, int horarioClausuraDiurno,
			int horarioAperturaNocturno, int horarioClausuraNocturno) {
		super();
		this.id = id;
		this.cantidadCocineros = cantidadCocineros;
		this.horarioAperturaDiurno = horarioAperturaDiurno;
		this.horarioClausuraDiurno = horarioClausuraDiurno;
		this.horarioAperturaNocturno = horarioAperturaNocturno;
		this.horarioClausuraNocturno = horarioClausuraNocturno;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCantidadCocineros() {
		return cantidadCocineros;
	}

	public void setCantidadCocineros(int cantidadCocineros) {
		this.cantidadCocineros = cantidadCocineros;
	}



	public int getHorarioAperturaDiurno() {
		return horarioAperturaDiurno;
	}



	public void setHorarioAperturaDiurno(int horarioAperturaDiurno) {
		this.horarioAperturaDiurno = horarioAperturaDiurno;
	}



	public int getHorarioClausuraDiurno() {
		return horarioClausuraDiurno;
	}



	public void setHorarioClausuraDiurno(int horarioClausuraDiurno) {
		this.horarioClausuraDiurno = horarioClausuraDiurno;
	}



	public int getHorarioAperturaNocturno() {
		return horarioAperturaNocturno;
	}



	public void setHorarioAperturaNocturno(int horarioAperturaNocturno) {
		this.horarioAperturaNocturno = horarioAperturaNocturno;
	}



	public int getHorarioClausuraNocturno() {
		return horarioClausuraNocturno;
	}



	public void setHorarioClausuraNocturno(int horarioClausuraNocturno) {
		this.horarioClausuraNocturno = horarioClausuraNocturno;
	}
	
	
	
	
}
