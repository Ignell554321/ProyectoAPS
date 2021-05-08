package com.GMT.Services;

import com.GMT.Commons.IGenericService;
import com.GMT.Entidad.Estudiante;

public interface IEstudianteService  extends IGenericService<Estudiante, String>{

	public Estudiante buscarDni(String dni);
}
