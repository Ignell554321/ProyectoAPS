package com.GMT.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.GMT.Commons.GenericServiceImpl;
import com.GMT.Entidad.Inscripcion;
import com.GMT.Persistencia.IInscripcionDAO;

@Service
public class InscripcionServiceImpl extends GenericServiceImpl<Inscripcion, Integer> implements IInscripcionService{

	@Autowired
	private IInscripcionDAO inscripcionDAO;

	@Override
	public CrudRepository<Inscripcion, Integer> getDAO() {
		// TODO Auto-generated method stub
		return inscripcionDAO;
	}


}
