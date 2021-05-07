package com.GMT.Services;

import java.util.List;

import com.GMT.Entidad.Horario;

public interface IHorarioService {

	public List<Horario>Listar();
	public void Insertar(Horario entity);
	public void Editar(Horario entity);
	public void Eliminar(Horario entity);
}
