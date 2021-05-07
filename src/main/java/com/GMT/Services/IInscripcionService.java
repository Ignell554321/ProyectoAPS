package com.GMT.Services;

import java.util.List;

import com.GMT.Entidad.Inscripcion;


public interface IInscripcionService {

	public List<Inscripcion>Listar();
	public void Insertar(Inscripcion entity);
	public void Editar(Inscripcion entity);
	public void Eliminar(Inscripcion entity);
}
