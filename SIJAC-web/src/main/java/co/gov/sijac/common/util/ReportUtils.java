package co.gov.sijac.common.util;

import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JExcelApiExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;

/**
 * Clase Generica para la generacion de reportes
 * @author ENUNEZT
 */
public class ReportUtils {
	/**
	 * Metodo para la generacion de reportes a Excel
	 * @param pathReporte
	 * @param listObject
	 * @param parametros
	 */
	@SuppressWarnings("rawtypes")
	public static void generarReporteXLSLink(String pathReporte, List listObject,Map<String,Object> parametros, String nombre){
		ServletContext application = FacesUtils.getServletContext();
		String disenoReporte = application.getRealPath(pathReporte);
		JasperPrint print;
		try {
			 //Compilar el informe 
            JasperReport informeCompilado =JasperCompileManager.compileReport(disenoReporte+".jrxml");           
          
			
			if	(listObject!=null)	
			print = JasperFillManager.fillReport(informeCompilado, parametros, new JRBeanCollectionDataSource(listObject));
			else     
			print = JasperFillManager.fillReport(informeCompilado, parametros, new JREmptyDataSource());
				    
			    //  JasperExportManager.exportReportToPdfStream(print,FacesUtils.getServletResponse().getOutputStream() );
			    FacesUtils.getServletResponse().setContentType("application/vnd.ms-excel");
				FacesUtils.getServletResponse().setHeader("Content-Disposition", "inline; filename=\""+nombre+".xls\"");
				JExcelApiExporter  xlsExporter2 = new JExcelApiExporter ();
				xlsExporter2.setParameter(JRXlsExporterParameter.JASPER_PRINT, print); 
				xlsExporter2.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, FacesUtils.getServletResponse().getOutputStream());
				xlsExporter2.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);		 
				xlsExporter2.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);				
				xlsExporter2.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
				xlsExporter2.exportReport();
				
				FacesContext.getCurrentInstance().responseComplete();

		} catch (Exception e) {
			e.printStackTrace();
			FacesUtils.addErrorMessage(e.getMessage());
		}
	}
	
	 public static void generarReportePDFLink(String pathReporte, List listObject,Map<String,Object> parametros, String nombre) {
         ServletContext application = FacesUtils.getServletContext();
         String disenoReporte = application.getRealPath(pathReporte);
         JasperPrint print;        
         try {
        	 //Compilar el informe 
             JasperReport informeCompilado =JasperCompileManager.compileReport(disenoReporte+".jrxml");           
           
               if    (listObject!=null)      
               print = JasperFillManager.fillReport(informeCompilado, parametros, new JRBeanCollectionDataSource(listObject));
               else     
               print = JasperFillManager.fillReport(informeCompilado, parametros, new JREmptyDataSource());
               FacesUtils.getServletResponse().setContentType("application/pdf");
               FacesUtils.getServletResponse().setHeader("Content-Disposition", "attachment;filename="+nombre+".pdf");

               net.sf.jasperreports.engine.export.JRPdfExporter exporter = new JRPdfExporter();
                 exporter.setParameter( JRPdfExporterParameter.JASPER_PRINT, print );
                 exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, FacesUtils.getServletResponse().getOutputStream());                                  
                 exporter.exportReport();
                     //JasperExportManager.exportReportToPdfStream(print, FacesUtils

                          //.getServletResponse().getOutputStream());
                  FacesContext.getCurrentInstance().responseComplete();
         } catch (Exception e) {
        	 e.printStackTrace();
 			FacesUtils.addErrorMessage(e.getMessage());
         }           
   }
	

}
