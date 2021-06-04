package com.GMT.Controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServletRequest;

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
import com.GMT.Entidad.Inscripcion;
import com.GMT.Services.EstudianteServiceImpl;
import com.GMT.Services.InscripcionServiceImpl;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
@RequestMapping("/Inscripcion")
public class InscripcionController {

	ObjectMapper Obj = new ObjectMapper();
	
	@Autowired
	private InscripcionServiceImpl inscripcionServicioImpl;
	
	@Autowired
	private EstudianteServiceImpl estudianteServiceImpl;
	
	@RequestMapping(value= {"/Paginado"},method=RequestMethod.GET)
	public String paginado(@RequestParam Map<String,Object> params, Model model) {
		
		 //Si el valor de page es diferente de null se resta 1, caso contrario su valor sera 0 debido a que esta en la primera pagina
		 int page= params.get("page") != null ? (Integer.valueOf(params.get("page").toString()) - 1) : 0; 
		 int tamanioPaginado= params.get("pageSize") != null ? (Integer.valueOf(params.get("pageSize").toString()) ) : 10; 
		 
		 PageRequest pageRequest=PageRequest.of(page, tamanioPaginado); //RECIBE COMO PARAMETROS LA PAGINA Y EL TAMAÑO DE PAGINA
		 
		 Page<Inscripcion> pageInscripcion=inscripcionServicioImpl.paginado(pageRequest); //OBTENEMOS EL LISTADO DE ESTUDIANTES
		 int primeraFila=0;
		 int ultimaFila=0;
		 
		 int totalPage = pageInscripcion.getTotalPages(); //OBTENEMOS EL TOTAL DE PAGINAS
		 if(pageInscripcion.getTotalElements()>0)primeraFila=1; //SI EXISTEN ELEMENTOS SE INICIALIZA EN 1 
		 primeraFila=primeraFila+(tamanioPaginado*page); // OBTENEMOS EL NUMERO DEL PRIMER REGISTRO DEL PAGINADO
		 ultimaFila=pageInscripcion.getContent().size()+(tamanioPaginado*page); //OBTENEMOS LA ULTIMA FILA
		 
		 if(totalPage>0) {
			//CREAMOS UN ARRAY QUE VAYA DESDE EL NUMERO 1 HASTA EL ULTIMO NUMERO DE PAGINA
			 List<Integer>pages=IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList()); 
			 model.addAttribute("pages",pages);
		 }
		 String informacionPaginado="Mostrando "+primeraFila+" al "+ultimaFila+" de "+pageInscripcion.getTotalElements()+" registros";
		 
		 model.addAttribute("lista",pageInscripcion.getContent());
		 model.addAttribute("tamanioPaginado",tamanioPaginado);
		 model.addAttribute("selectedPageSize",tamanioPaginado);
		 model.addAttribute("current",page+1); //PAGINA ACTUAL
		 model.addAttribute("next",page+2); //SIGUENTE PAGINA
		 model.addAttribute("prev",page); //PAGINA ANTERIOR
		 model.addAttribute("last",totalPage); //TOTAL PAGINAS 
		 model.addAttribute("info",informacionPaginado); //INFO 
		 model.addAttribute("html","GestionarInscripcion/listarInscripcion");
		 model.addAttribute("template","listarInscripcion");
		 return "fragments/layout";	 
	}
	
	@RequestMapping(value= {"/Guardar"},method=RequestMethod.GET)
	public String registro( Model model) {
		
		model.addAttribute("inscripcion",new Inscripcion());
		 model.addAttribute("html","GestionarInscripcion/registrarInscripcion");
		 model.addAttribute("template","registrarInscripcion");
		 return "fragments/layout";	
	}
	
	@RequestMapping(value= {"/BuscarEstudiante"},method=RequestMethod.POST)
	public String buscarEstudiante(HttpServletRequest request) throws JsonParseException, JsonMappingException, IOException{
		
		 String dni= request.getParameter("dni");
		 System.out.print(dni);
		 Estudiante entity=estudianteServiceImpl.buscar(dni);
		 if(entity!=null) {
			 return Obj.writeValueAsString(entity);
		 }else {
			 return Obj.writeValueAsString("");
		 }
		 
		 
	}
}
