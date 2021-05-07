package com.GMT.Services;

import java.util.List;

import com.GMT.Entidad.Certificado;

public interface ICertificadoService {

	public List<Certificado>Listar();
	public void Insertar(Certificado entity);
	public void Editar(Certificado entity);
	public void Eliminar(Certificado entity);
	
}
