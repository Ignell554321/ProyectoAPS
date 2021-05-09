package com.GMT.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.GMT.Commons.GenericServiceImpl;
import com.GMT.Entidad.Instructor;
import com.GMT.Persistencia.IInstructorDAO;

@Service
public class InstructorServiceImpl extends GenericServiceImpl<Instructor, String> implements IInstructorService{

	@Autowired
	private IInstructorDAO instructorDAO;


	@Override
	public Instructor buscarDni(String dni) {
		// TODO Auto-generated method stub
		return instructorDAO.findBydni(dni);
	}


	@Override
	public JpaRepository<Instructor, String> getDAO() {
		// TODO Auto-generated method stub
		return instructorDAO;
	}

}
