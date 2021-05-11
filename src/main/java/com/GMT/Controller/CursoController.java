package com.GMT.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.GMT.Entidad.Curso;
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
	
	ObjectMapper Obj = new ObjectMapper();
	
	@RequestMapping(value= {"/Guardar"},method=RequestMethod.GET)
	public String listarCompra(Model model) {
		
		 model.addAttribute("listaDocentes",instructorServiceImpl.listar());
		 model.addAttribute("curso",new Curso());
		 model.addAttribute("html","GestionarCurso/registrarCurso");
		 model.addAttribute("template","registrarCurso");
		 return "fragments/layout";	
	}
	
	
	//CREAR
	@RequestMapping(value= {"/Guardar"},method=RequestMethod.POST)
	public String guardar(Curso entity, Model model) {
		
		System.out.print("Hora Inicio: "+entity.getHorario().getHoraDeInicio()+"\n");
		System.out.print("Hora Fin: "+entity.getHorario().getHoraDeFin()+"\n");
		entity.getHorario().setPeriodo("3");
		entity.getInstructor().setDni("78541236");
		cursoServiceImpl.Insertar(entity);
		 return "redirect:/Curso/Guardar";
	}
	
}
