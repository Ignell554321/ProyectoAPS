package com.GMT.Commons;

import java.io.Serializable;
import java.util.List;

public interface IGenericService <T,ID extends Serializable>{
	
	T guardar(T entity);
	void eliminar(T entity);
	T buscar(ID id);
	List<T> listar();
	
}
