package com.GMT.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.GMT.Entidad.Instructor;
import com.GMT.Persistencia.IInstructorDAO;

@Service
public class InstructorServiceImpl implements IInstructorService {

	@Autowired
	private IInstructorDAO instructorDAO;

	@Override
	public List<Instructor> Listar() {
		// TODO Auto-generated method stub
		return instructorDAO.findAll();
	}

	@Override
	public void Insertar(Instructor entity) {
		// TODO Auto-generated method stub
		instructorDAO.save(entity);
	}

	@Override
	public void Editar(Instructor entity) {
		// TODO Auto-generated method stub
		instructorDAO.save(entity);
	}

	@Override
	public void Eliminar(Instructor entity) {
		// TODO Auto-generated method stub
		instructorDAO.delete(entity);
	}
	


}
