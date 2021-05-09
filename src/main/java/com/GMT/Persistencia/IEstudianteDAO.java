package com.GMT.Persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.GMT.Entidad.Estudiante;

@Repository
public interface IEstudianteDAO extends JpaRepository<Estudiante, String>{

	public Estudiante findBydni(String dni);
	public Estudiante deleteBydni(String dni);
	@Query(nativeQuery = true, value = "CALL spPaginadoEstudiante(?1,?2)")
	public List<Estudiante> paginado(int numeroPagina,int tamanioPagina);
}
