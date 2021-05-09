package com.GMT.Controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	
	//PAGINADO
	@RequestMapping(value= {"/Paginado"},method=RequestMethod.GET)
	public String paginado(@RequestParam Map<String,Object> params, Model model) {
		
		 //Si el valor de page es diferente de null se resta 1, caso contrario su valor sera 0 debido a que esta en la primera pagina
		 int page= params.get("page") != null ? (Integer.valueOf(params.get("page").toString()) - 1) : 0; 
		 
		 PageRequest pageRequest=PageRequest.of(page, 10); //RECIBE COMO PARAMETROS LA PAGINA Y EL TAMAÑO DE PAGINA
		 
		 Page<Instructor> pageInstructor=instructorServiceImpl.paginado(pageRequest); //OBTENEMOS EL LISTADO DE INSTRUCTORES
		 
		 int totalPage = pageInstructor.getTotalPages(); //OBTENEMOS EL TOTAL DE PAGINAS
		 
		 if(totalPage>0) {
			//CREAMOS UN ARRAY QUE VAYA DESDE EL NUMERO 1 HASTA EL ULTIMO NUMERO DE PAGINA
			 List<Integer>pages=IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList()); 
			 model.addAttribute("pages",pages);
		 }
		 
		 model.addAttribute("lista",pageInstructor.getContent());
		 model.addAttribute("current",page+1); //PAGINA ACTUAL
		 model.addAttribute("next",page+2); //SIGUENTE PAGINA
		 model.addAttribute("prev",page); //PAGINA ANTERIOR
		 model.addAttribute("last",totalPage); //TOTAL PAGINAS 
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