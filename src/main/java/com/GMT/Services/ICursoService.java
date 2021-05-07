package com.GMT.Services;

import java.util.List;

import com.GMT.Entidad.Curso;

public interface ICursoService {

	public List<Curso>Listar();
	public void Insertar(Curso entity);
	public void Editar(Curso entity);
	public void Eliminar(Curso entity);
	
}
