package com.GMT.Entidad;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Inscripcion {
 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "estudiante_id")
	private Estudiante estudiante;
	
	@OneToOne
	@JoinColumn(name = "curso_id")
	private Curso curso;
	
	@OneToOne
	@JoinColumn(name = "maquina_id")
	private Maquina maquina;
	
	/*@OneToMany(mappedBy = "inscripcion")
	private List<Pago> pago;*/
	
	@Column(name="tipoDeInscripcion", nullable = false, length = 45)
	private String tipoDeInscripcion;
	
	@Column(name="fecha", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date fecha;
	
	@Column(name="monto", nullable = false)
	private double monto;
	
	public Inscripcion() {
		
		//this.pago=new ArrayList<Pago>();
		this.curso=new Curso();
		this.maquina=new Maquina();
		this.estudiante=new Estudiante();
		
	}

	
	
	public Maquina getMaquina() {
		return maquina;
	}

	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	/*public List<Pago> getPago() {
		return pago;
	}

	public void setPago(List<Pago> pago) {
		this.pago = pago;
	}*/

	public String getTipoDeInscripcion() {
		return tipoDeInscripcion;
	}

	public void setTipoDeInscripcion(String tipoDeInscripcion) {
		this.tipoDeInscripcion = tipoDeInscripcion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}
	
	
}
