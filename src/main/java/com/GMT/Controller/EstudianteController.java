package com.GMT.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.GMT.Entidad.Estudiante;
import com.GMT.Services.EstudianteServiceImpl;
import com.GMT.Services.IEstudianteService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/Estudiante")
public class EstudianteController {

	ObjectMapper Obj = new ObjectMapper();
	
	@Autowired
	private EstudianteServiceImpl estudianteServiceImpl;	
	
	@RequestMapping(value= {"/Listar"},method=RequestMethod.GET)
	public String listar(Model model) {
		
		 model.addAttribute("lista",estudianteServiceImpl.listar());
		 model.addAttribute("html","GestionarEstudiante/listarEstudiante");
		 model.addAttribute("template","listarEstudiante");
		 return "fragments/layout";	 
	}
	
	@RequestMapping(value= {"/Guardar"},method=RequestMethod.GET)
	public String registro( Model model) {
		
		
		model.addAttribute("estudiante",new Estudiante());
		 model.addAttribute("html","GestionarEstudiante/registrarEstudiante");
		 model.addAttribute("template","registrarEstudiante");
		 return "fragments/layout";	
	}
	
	@RequestMapping(value= {"/Editar/{dni}"},method=RequestMethod.GET)
	public String registro( @PathVariable("dni") String dni, Model model) {
		
		
		Estudiante entity=estudianteServiceImpl.buscarDni(dni);
		
		if(entity==null) {
			 return "redirect:/Estudiante/Listar";
		}
		
		model.addAttribute("estudiante",entity);
		 model.addAttribute("html","GestionarEstudiante/registrarEstudiante");
		 model.addAttribute("template","registrarEstudiante");
		 return "fragments/layout";	
	}
	
	
	@RequestMapping(value= {"/Guardar"},method=RequestMethod.POST)
	public String guardar(Estudiante entity, Model model) {
		
		 estudianteServiceImpl.guardar(entity);
		/* model.addAttribute("html","GestionarEstudiante/listarEstudiante");
		 model.addAttribute("template","listarEstudiante");
		 return "fragments/layout";	*/
		 return "redirect:/Estudiante/Listar";
	}
	
	@RequestMapping(value= {"/Eliminar/{dni}"},method=RequestMethod.GET)
	public String eliminar(@PathVariable("dni") String dni, Model model) {
		
		Estudiante entity=estudianteServiceImpl.buscarDni(dni);
		
		if(entity!=null) {
			estudianteServiceImpl.eliminar(entity);
		}
		
		 return "redirect:/Estudiante/Listar";
	}
	
}
