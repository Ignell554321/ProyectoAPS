package com.GMT.Services;


import com.GMT.Commons.IGenericService;
import com.GMT.Entidad.Instructor;

public interface IInstructorService extends IGenericService<Instructor, String>{

	public Instructor buscarDni(String dni);
}
