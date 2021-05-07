package com.GMT.Persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GMT.Entidad.Estudiante;

@Repository
public interface IEstudianteDAO extends JpaRepository<Estudiante, String>{

	public Estudiante findBydni(String dni);
	public Estudiante deleteBydni(String dni);
}
