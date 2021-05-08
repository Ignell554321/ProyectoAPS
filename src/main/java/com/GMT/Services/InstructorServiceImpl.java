package com.GMT.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.GMT.Commons.GenericServiceImpl;
import com.GMT.Entidad.Instructor;
import com.GMT.Persistencia.IInstructorDAO;

@Service
public class InstructorServiceImpl extends GenericServiceImpl<Instructor, String> implements IInstructorService{

	@Autowired
	private IInstructorDAO instructorDAO;

	@Override
	public CrudRepository<Instructor, String> getDAO() {
		
		return instructorDAO;
	}
	@Override
	public Instructor buscarDni(String dni) {
		// TODO Auto-generated method stub
		return instructorDAO.findBydni(dni);
	}

}
