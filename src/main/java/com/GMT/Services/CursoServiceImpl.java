package com.GMT.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.GMT.Entidad.Curso;
import com.GMT.Persistencia.ICursoDAO;
import com.GMT.Persistencia.IHorarioDAO;

@Service
public class CursoServiceImpl implements ICursoService {

	@Autowired
	private ICursoDAO cursoDAO;
	@Autowired
	private IHorarioDAO horarioDAO;
	
	@Override
	public List<Curso> Listar() {
		// TODO Auto-generated method stub
		return cursoDAO.findAll();
	}

	@Override
	public void Insertar(Curso entity) {
		// TODO Auto-generated method stub
		horarioDAO.save(entity.getHorario());
		cursoDAO.save(entity);
	}

	@Override
	public void Editar(Curso entity) {
		// TODO Auto-generated method stub
		cursoDAO.save(entity);
	}

	@Override
	public void Eliminar(Curso entity) {
		// TODO Auto-generated method stub
		cursoDAO.delete(entity);
	}

}
