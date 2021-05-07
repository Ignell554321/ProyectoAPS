package com.GMT.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Horario {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name = "horaDeInicio", nullable = false,length = 20)
	private String horaDeInicio;
	
	@Column(name = "horaDeFin", nullable = false,length = 20)
	private String horaDeFin;
	
	@Column(name = "periodo", nullable = false,length = 15)
	private String periodo;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHoraDeInicio() {
		return horaDeInicio;
	}

	public void setHoraDeInicio(String horaDeInicio) {
		this.horaDeInicio = horaDeInicio;
	}

	public String getHoraDeFin() {
		return horaDeFin;
	}

	public void setHoraDeFin(String horaDeFin) {
		this.horaDeFin = horaDeFin;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
	
}
