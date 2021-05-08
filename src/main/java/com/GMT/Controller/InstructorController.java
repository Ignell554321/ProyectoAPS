package com.GMT.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.GMT.Entidad.Estudiante;
import com.GMT.Entidad.Instructor;
import com.GMT.Services.InstructorServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/Instructor")
public class InstructorController {

	ObjectMapper Obj = new ObjectMapper();
	
	@Autowired
	private InstructorServiceImpl instructorServiceImpl;	
	
	@RequestMapping(value= {"/Listar"},method=RequestMethod.GET)
	public String listar(Model model) {
		
		 model.addAttribute("lista",instructorServiceImpl.listar());
		 model.addAttribute("html","GestionarInstructor/listarInstructor");
		 model.addAttribute("template","listarInstructor");
		 return "fragments/layout";	 
	}
	
	@RequestMapping(value= {"/Guardar"},method=RequestMethod.GET)
	public String registro( Model model) {
		
		//@PathVariable("dni") String dni,
		/*if(dni!=null) {
			model.addAttribute("estudiante",estudianteServiceImpl.buscar(dni));
		}*/
		model.addAttribute("instructor",new Instructor());
		 model.addAttribute("html","GestionarInstructor/registrarInstructor");
		 model.addAttribute("template","registrarInstructor");
		 return "fragments/layout";	
	}
	
	@RequestMapping(value= {"/Guardar"},method=RequestMethod.POST)
	public String guardar(Instructor entity, Model model) {
		
		 instructorServiceImpl.guardar(entity);
		 return "redirect:/Instructor/Listar";
	}
	
	@RequestMapping(value= {"/Editar/{dni}"},method=RequestMethod.GET)
	public String registro( @PathVariable("dni") String dni, Model model) {
		
		
		Instructor entity=instructorServiceImpl.buscarDni(dni);
		
		if(entity==null) {
			 return "redirect:/Instructor/Listar";
		}
		
		 model.addAttribute("instructor",entity);
		 model.addAttribute("html","GestionarInstructor/registrarInstructor");
		 model.addAttribute("template","registrarInstructor");
		 return "fragments/layout";	
	}
	
	@RequestMapping(value= {"/Eliminar/{dni}"},method=RequestMethod.GET)
	public String eliminar(@PathVariable("dni") String dni, Model model) {
		
		Instructor entity=instructorServiceImpl.buscarDni(dni);
		
		if(entity!=null) {
			instructorServiceImpl.eliminar(entity);
		}
		
		 return "redirect:/Instructor/Listar";
	}
	
}