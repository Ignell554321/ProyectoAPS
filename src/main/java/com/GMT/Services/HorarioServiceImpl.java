package com.GMT.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.GMT.Entidad.Horario;
import com.GMT.Persistencia.IHorarioDAO;

@Service
public class HorarioServiceImpl implements IHorarioService {

	@Autowired
	private IHorarioDAO horarioDAO;
	
	@Override
	public List<Horario> Listar() {
		// TODO Auto-generated method stub
		return horarioDAO.findAll();
	}

	@Override
	public void Insertar(Horario entity) {
		// TODO Auto-generated method stub
		horarioDAO.save(entity);
	}

	@Override
	public void Editar(Horario entity) {
		// TODO Auto-generated method stub
		horarioDAO.save(entity);
	}

	@Override
	public void Eliminar(Horario entity) {
		// TODO Auto-generated method stub
		horarioDAO.delete(entity);
	}

}
