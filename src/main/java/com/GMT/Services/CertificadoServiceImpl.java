package com.GMT.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.GMT.Entidad.Certificado;
import com.GMT.Persistencia.ICertificadoDAO;

@Service
public class CertificadoServiceImpl implements ICertificadoService {

	@Autowired
	private ICertificadoDAO certificadoDAO; 
	
	@Override
	public List<Certificado> Listar() {
		// TODO Auto-generated method stub
		//return certificadoDAO.findAll();
		return null;
	}

	@Override
	public void Insertar(Certificado entity) {
		// TODO Auto-generated method stub
		certificadoDAO.save(entity);
	}

	@Override
	public void Editar(Certificado entity) {
		// TODO Auto-generated method stub
		certificadoDAO.save(entity);
	}

	@Override
	public void Eliminar(Certificado entity) {
		// TODO Auto-generated method stub
		certificadoDAO.delete(entity);
	}

}
