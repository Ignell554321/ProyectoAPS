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
	@JoinColumn(name = "estudiante_dni")
	private Estudiante estudiante;
	
	@OneToOne
	@JoinColumn(name = "curso_id")
	private Curso curso;
	
	@OneToOne
	@JoinColumn(name = "maquina_id")
	private Maquina maquina;
	
	/*@OneToMany(mappedBy = "inscripcion")
	private List<Pago> pago;*/
	
	/*@Column(name="tipoDeInscripcion", nullable = false, length = 45)
	private String tipoDeInscripcion;*/
	
	/*@Column(name="fecha", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date fecha;*/
	
	@Column(name="fechaActual", nullable = false, length = 15)
	private String fechaActual;
	
	@Column(name="departamento", nullable = false, length = 45)
	private String departamento;
	
	@Column(name="provincia", nullable = false, length = 45)
	private String provincia;
	
	@Column(name="distrito", nullable = false, length = 45)
	private String distrito;
	
	@Column(name="MontoTotal", nullable = false)
	private float MontoTotal;
	
	@Column(name="MontoRestante", nullable = false)
	private float MontoRestante;
	
	@Column(name="promocion", nullable = false, length = 15)
	private String promocion;
	
	@Column(name="turno", nullable = false, length = 25)
	private String turno;
	
	
	
	public Inscripcion() {
		
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


	public String getFechaActual() {
		return fechaActual;
	}


	public void setFechaActual(String fechaActual) {
		this.fechaActual = fechaActual;
	}


	public String getDepartamento() {
		return departamento;
	}


	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}



	public String getProvincia() {
		return provincia;
	}



	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}



	public String getDistrito() {
		return distrito;
	}



	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}



	public float getMontoTotal() {
		return MontoTotal;
	}



	public void setMontoTotal(float montoTotal) {
		MontoTotal = montoTotal;
	}



	public float getMontoRestante() {
		return MontoRestante;
	}



	public void setMontoRestante(float montoRestante) {
		MontoRestante = montoRestante;
	}



	public String getPromocion() {
		return promocion;
	}



	public void setPromocion(String promocion) {
		this.promocion = promocion;
	}



	public String getTurno() {
		return turno;
	}



	public void setTurno(String turno) {
		this.turno = turno;
	}

	/*public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}*/


	
	
	
}
