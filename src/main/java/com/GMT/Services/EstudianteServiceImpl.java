package com.GMT.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.GMT.Commons.GenericServiceImpl;
import com.GMT.Entidad.Estudiante;
import com.GMT.Entidad.Paginado;
import com.GMT.Persistencia.IEstudianteDAO;

@Service
public class EstudianteServiceImpl extends GenericServiceImpl<Estudiante, String> implements IEstudianteService{

	@Autowired
	private IEstudianteDAO estudianteDAO;
	


	@Override
	public Estudiante buscarDni(String dni) {
		// TODO Auto-generated method stub
		return estudianteDAO.findBydni(dni);
	}

	@Override
	public Paginado<Estudiante> paginacion(int numeroPagina, int tamanioPagina) {
		
		Paginado<Estudiante> paginado=new Paginado<Estudiante>();
		

		List<Estudiante>lista=estudianteDAO.findAll();
		
		if(lista.size()>0)paginado.setPrimeraFila(1);
		paginado.setTotalfilas(estudianteDAO.findAll().size());
		
		paginado.setPrimeraFila(paginado.getPrimeraFila()+(tamanioPagina*(numeroPagina-1)));
		paginado.setUltimaFila(lista.size()+(tamanioPagina*(numeroPagina-1)));
		paginado.setTotalPaginas(paginado.getTotalfilas()/tamanioPagina);
		if(paginado.getTotalfilas()%tamanioPagina!=0) paginado.setTotalPaginas(paginado.getTotalPaginas()+1);;
		
		paginado.setFilas(estudianteDAO.paginado(numeroPagina, tamanioPagina));
		return paginado;
	}

	@Override
	public JpaRepository<Estudiante, String> getDAO() {
		// TODO Auto-generated method stub
		return estudianteDAO;
	}





}
