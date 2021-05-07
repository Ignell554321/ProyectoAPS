package com.GMT.Persistencia;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.GMT.Entidad.Certificado;

@Repository
public interface ICertificadoDAO extends CrudRepository<Certificado,Integer>{

}
