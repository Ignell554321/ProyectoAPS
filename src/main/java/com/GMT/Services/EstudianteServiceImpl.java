package com.GMT.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.GMT.Commons.GenericServiceImpl;
import com.GMT.Entidad.Estudiante;
import com.GMT.Persistencia.IEstudianteDAO;

@Service
public class EstudianteServiceImpl extends GenericServiceImpl<Estudiante, String> implements IEstudianteService{

	@Autowired
	private IEstudianteDAO estudianteDAO;
	
	@Override
	public CrudRepository<Estudiante, String> getDAO() {
		
		return estudianteDAO;
	}

	@Override
	public Estudiante buscarDni(String dni) {
		// TODO Auto-generated method stub
		return estudianteDAO.findBydni(dni);
	}





}
