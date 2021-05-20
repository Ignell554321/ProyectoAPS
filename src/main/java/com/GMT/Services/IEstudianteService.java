package com.GMT.Services;



import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;


import com.GMT.Commons.IGenericService;
import com.GMT.Entidad.Estudiante;
import com.GMT.Entidad.Paginado;

public interface IEstudianteService  extends IGenericService<Estudiante, String>{

	public Estudiante buscarDni(String dni);
	public Paginado<Estudiante> paginacion(int numeroPagina,int tamanioPagina);
	public Page<Estudiante>  buscar(String dni,Pageable pageable);
}
