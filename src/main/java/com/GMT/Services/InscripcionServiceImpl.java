package com.GMT.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GMT.Entidad.Inscripcion;
import com.GMT.Persistencia.IInscripcionDAO;

@Service
public class InscripcionServiceImpl implements IInscripcionService {

	@Autowired
	private IInscripcionDAO inscripcionDAO;
	
	@Override
	public List<Inscripcion> Listar() {
		// TODO Auto-generated method stub
		return inscripcionDAO.findAll();
	}

	@Override
	public void Insertar(Inscripcion entity) {
		// TODO Auto-generated method stub
		inscripcionDAO.save(entity);

	}

	@Override
	public void Editar(Inscripcion entity) {
		// TODO Auto-generated method stub
		inscripcionDAO.save(entity);
	}

	@Override
	public void Eliminar(Inscripcion entity) {
		// TODO Auto-generated method stub
		inscripcionDAO.delete(entity);
	}

}
