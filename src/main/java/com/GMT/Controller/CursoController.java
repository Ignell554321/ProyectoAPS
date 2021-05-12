package com.GMT.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.persistence.ElementCollection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.GMT.Entidad.Curso;
import com.GMT.Entidad.Horario;
import com.GMT.Services.CursoServiceImpl;
import com.GMT.Services.InstructorServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/Curso")
public class CursoController {

	@Autowired
	private CursoServiceImpl cursoServiceImpl;
	@Autowired
	private InstructorServiceImpl instructorServiceImpl;
	@ElementCollection
    private List<Horario> listaHorarios=  new ArrayList<Horario>();
	
	ObjectMapper Obj = new ObjectMapper();
	
	@RequestMapping(value= {"/Guardar"},method=RequestMethod.GET)
	public String listarCompra(Model model) {
		
		 listaHorarios.clear();
		 List<Integer>horas=IntStream.rangeClosed(0, 23).boxed().collect(Collectors.toList()); 
		 List<Integer>minutos=IntStream.rangeClosed(0, 59).boxed().collect(Collectors.toList()); 
		 model.addAttribute("horas",horas);
		 model.addAttribute("minutos",minutos);
		 model.addAttribute("listaDocentes",instructorServiceImpl.listar());
		 model.addAttribute("curso",new Curso());
		 model.addAttribute("html","GestionarCurso/registrarCurso");
		 model.addAttribute("template","registrarCurso");
		 return "fragments/layout";	
	}
	
	
	//CREAR
	@RequestMapping(value= {"/Guardar"},method=RequestMethod.POST)
	public String guardar(Curso entity, Model model) {
		
		entity.getHorario().setPeriodo("3");
		//System.out.print(entity.getInstructor().getDni());
		cursoServiceImpl.Insertar(entity);
		 return "redirect:/Curso/Guardar";
	}
	
}
