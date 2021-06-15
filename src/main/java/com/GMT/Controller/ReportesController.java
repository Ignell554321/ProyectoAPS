package com.GMT.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

@Controller
@RequestMapping("/Reporte")
public class ReportesController {
	
	//CONEXION BASE DE DATOS ACTUAL
	@Autowired
	protected DataSource datasource;
	
	//DESCARGAR REPORTE EN PDF
	@RequestMapping(value = "/DescargarPDF", method = RequestMethod.GET)
	  @ResponseBody
	  public void descargaPDF(HttpServletResponse response) throws  IOException, JRException, SQLException {
		  
	    InputStream jasperStream = this.getClass().getResourceAsStream("/Reportes/Invoice.jasper");
	    JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
	    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null,datasource.getConnection());
	    response.setContentType("application/x-pdf");
	    response.setHeader("Content-disposition", "inline; filename=historialEstudiantes.pdf");
	    final OutputStream outStream = response.getOutputStream();
	    JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
	    
	  }
	
	//VISUALIZAR REPORTE EN PDF
	@RequestMapping(value ="/VistaPrevia", method = RequestMethod.GET)
    public void vistaPreviaPDF( HttpServletRequest request,HttpServletResponse response) throws  Exception{


		InputStream jasperStream = this.getClass().getResourceAsStream("/Reportes/Invoice.jasper");
	    JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, datasource.getConnection());
        
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline;");
        final OutputStream outputStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
 
    }
	
	@RequestMapping(value ="/Inscripcion/{idInscripcion}", method = RequestMethod.GET)
    public void vistaPreviaInscripcionPDF( HttpServletRequest request,HttpServletResponse response,@PathVariable(value="idInscripcion") int idInscripcion) throws  Exception{


		InputStream jasperStream = this.getClass().getResourceAsStream("/Reportes/inscripcion.jasper");
		Map<String,Object> params = new HashMap();
		params.put("idInscripcion", idInscripcion);
	    JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, datasource.getConnection());
        
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline;");
        final OutputStream outputStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
 
    }
	
	@RequestMapping(value ="/Morosos", method = RequestMethod.GET)
    public void vistaPreviaMorososPDF( HttpServletRequest request,HttpServletResponse response) throws  Exception{


		InputStream jasperStream = this.getClass().getResourceAsStream("/Reportes/estudiantesMorosos.jasper");

	    JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, datasource.getConnection());
        
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline;");
        final OutputStream outputStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
 
    }

	

}
