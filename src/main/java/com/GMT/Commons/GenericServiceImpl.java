package com.GMT.Commons;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class GenericServiceImpl<T,ID extends Serializable > implements IGenericService<T, ID> {
	
	@Override
	public T guardar(T entity) {
		// TODO Auto-generated method stub
		return getDAO().save(entity);
	}

	@Override
	public void eliminar(T entity) {
		// TODO Auto-generated method stub
		 getDAO().delete(entity);
	}

	@Override
	public T buscar(ID id) {
		Optional<T> obj=getDAO().findById(id);
		if(obj.isPresent()){
			return obj.get();
		}
		return null;
	}

	@Override
	public List<T> listar() {
		List<T> returnList = new ArrayList<>();
		getDAO().findAll().forEach(obj -> returnList.add(obj));
		return returnList;
	}

	
	public abstract CrudRepository<T,ID> getDAO();
	

}
