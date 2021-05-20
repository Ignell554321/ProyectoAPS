package com.GMT.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.persistence.ElementCollection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.GMT.Entidad.Curso;
import com.GMT.Entidad.Estudiante;
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
	
	//PAGINADO
		@RequestMapping(value= {"/Paginado"},method=RequestMethod.GET)
		public String paginado(@RequestParam Map<String,Object> params, Model model) {
			
			 //Si el valor de page es diferente de null se resta 1, caso contrario su valor sera 0 debido a que esta en la primera pagina
			 int page= params.get("page") != null ? (Integer.valueOf(params.get("page").toString()) - 1) : 0; 
			 
			 PageRequest pageRequest=PageRequest.of(page, 10); //RECIBE COMO PARAMETROS LA PAGINA Y EL TAMA�O DE PAGINA
			 
			 Page<Curso> pageCurso=cursoServiceImpl.paginado(pageRequest); //OBTENEMOS EL LISTADO DE ESTUDIANTES
			 
			 int totalPage = pageCurso.getTotalPages(); //OBTENEMOS EL TOTAL DE PAGINAS
			 
			 if(totalPage>0) {
				//CREAMOS UN ARRAY QUE VAYA DESDE EL NUMERO 1 HASTA EL ULTIMO NUMERO DE PAGINA
				 List<Integer>pages=IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList()); 
				 model.addAttribute("pages",pages);
			 }
			 
			 model.addAttribute("lista",pageCurso.getContent());
			 model.addAttribute("current",page+1); //PAGINA ACTUAL
			 model.addAttribute("next",page+2); //SIGUENTE PAGINA
			 model.addAttribute("prev",page); //PAGINA ANTERIOR
			 model.addAttribute("last",totalPage); //TOTAL PAGINAS 
			 model.addAttribute("html","GestionarCurso/listarCurso");
			 model.addAttribute("template","listarCurso");
			 return "fragments/layout";	 
		}
	
	//CREAR
		@RequestMapping(value= {"/Guardar"},method=RequestMethod.GET)
		public String registro( Model model) {
			
			
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
		return "redirect:/Curso/Paginado";
	}
	
}
