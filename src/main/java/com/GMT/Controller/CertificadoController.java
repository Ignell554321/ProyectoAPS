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

import com.GMT.Entidad.Certificado;
import com.GMT.Entidad.Curso;
import com.GMT.Entidad.Estudiante;
import com.GMT.Entidad.Maquina;
import com.GMT.Services.CertificadoServiceImpl;

@Controller
@RequestMapping("/Certificado")
public class CertificadoController {
	
	@Autowired
	private CertificadoServiceImpl certificadoServiceImpl;
	
	//PAGINADO
		@RequestMapping(value= {"/Paginado"},method=RequestMethod.GET)
		public String paginado(@RequestParam Map<String,Object> params, Model model) {
			
			 //Si el valor de page es diferente de null se resta 1, caso contrario su valor sera 0 debido a que esta en la primera pagina
			 int page= params.get("page") != null ? (Integer.valueOf(params.get("page").toString()) - 1) : 0; 
			 
			 PageRequest pageRequest=PageRequest.of(page, 10); //RECIBE COMO PARAMETROS LA PAGINA Y EL TAMAÑO DE PAGINA
			 
			 Page<Certificado> pageCertificado=certificadoServiceImpl.paginado(pageRequest); //OBTENEMOS EL LISTADO DE ESTUDIANTES
			 
			 int totalPage = pageCertificado.getTotalPages(); //OBTENEMOS EL TOTAL DE PAGINAS
			 
			 if(totalPage>0) {
				//CREAMOS UN ARRAY QUE VAYA DESDE EL NUMERO 1 HASTA EL ULTIMO NUMERO DE PAGINA
				 List<Integer>pages=IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList()); 
				 model.addAttribute("pages",pages);
			 }
			 
			 model.addAttribute("lista",pageCertificado.getContent());
			 model.addAttribute("current",page+1); //PAGINA ACTUAL
			 model.addAttribute("next",page+2); //SIGUENTE PAGINA
			 model.addAttribute("prev",page); //PAGINA ANTERIOR
			 model.addAttribute("last",totalPage); //TOTAL PAGINAS 
			 model.addAttribute("html","GestionarCertificado/listarCertificado");
			 model.addAttribute("template","listarCertificado");
			 return "fragments/layout";	 
		}
		
		@RequestMapping(value= {"/Guardar"},method=RequestMethod.GET)
		public String listarCompra(Model model) {
			
			 model.addAttribute("certificado",new Certificado());
			 model.addAttribute("html","GestionarCertificado/registrarCertificado");
			 model.addAttribute("template","registrarCertificado");
			 return "fragments/layout";	
		}
		
		//CREAR
		@RequestMapping(value= {"/Guardar"},method=RequestMethod.POST)
		public String guardar(Certificado entity, Model model) {
			
			certificadoServiceImpl.guardar(entity);
			return "redirect:/Certificado/Paginado";
		}
		
		//ACTUALIZAR
		@RequestMapping(value= {"/Editar/{id}"},method=RequestMethod.GET)
		public String registro( @PathVariable("id") int id, Model model) {
			
			
			Certificado entity=certificadoServiceImpl.buscar(id);
			
			if(entity==null) {
				 return "redirect:/Certificado/Paginado";
			}
			
			 model.addAttribute("certificado",entity);
			 model.addAttribute("html","GestionarCertificado/registrarCertificado");
			 model.addAttribute("template","registrarCertificado");
			 return "fragments/layout";	
		}
		
		//ELIMINAR
		@RequestMapping(value= {"/Eliminar/{id}"},method=RequestMethod.GET)
		public String eliminar(@PathVariable("id") int id, Model model) {
			
			Certificado entity=certificadoServiceImpl.buscar(id);
			
			if(entity!=null) {
				certificadoServiceImpl.eliminar(entity);
			}
			
			 return "redirect:/Certificado/Paginado";
		}

}
