package com.GMT.Entidad;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Maquina {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="tipoDeMaquina",nullable = false,length = 20)
	private String tipoDeMaquina;
	
	@Column(name="descripcion",nullable = false,length = 300)
	private String descripcion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoDeMaquina() {
		return tipoDeMaquina;
	}

	public void setTipoDeMaquina(String tipoDeMaquina) {
		this.tipoDeMaquina = tipoDeMaquina;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
