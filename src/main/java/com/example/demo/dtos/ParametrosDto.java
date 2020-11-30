package com.example.demo.dtos;

import javax.persistence.Column;

public class ParametrosDto {
	
	long id;
	int cantidadCocineros;
	int horarioAperturaDiurno;
	int horarioClausuraDiurno;
	int horarioAperturaNocturno;
	int horarioClausuraNocturno;
	
	
	public ParametrosDto() {
		super();
	}

	public ParametrosDto(long id, int cantidadCocineros, int horarioAperturaDiurno, int horarioClausuraDiurno,
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
