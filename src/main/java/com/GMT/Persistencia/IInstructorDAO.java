package com.GMT.Persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.GMT.Entidad.Instructor;

@Repository
public interface IInstructorDAO extends JpaRepository<Instructor,String>{

}
