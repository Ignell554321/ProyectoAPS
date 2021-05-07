package com.GMT.Services;

import java.util.List;

import com.GMT.Entidad.Instructor;

public interface IInstructorService {
	
	public List<Instructor>Listar();
	public void Insertar(Instructor entity);
	public void Editar(Instructor entity);
	public void Eliminar(Instructor entity);
}
