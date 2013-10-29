package co.gov.sijac.common.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import co.gov.sijac.common.util.FacesUtils;
import co.gov.sijac.common.util.ReportUtils;
import org.primefaces.component.datatable.DataTable;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;

public abstract class GenericoPrimeFacesController<ENT> extends AbstractGenericoController<ENT>{
	
	
	transient protected  DataTable tabla;
	protected int index;
	
	public GenericoPrimeFacesController() {	
		
	}
	
	 
   
    public String doCrear(){		
    
    	super.doCrear();
    	postSucess();
    	
    	
    	return null;    	
    }
 
  
    public String doActualizar(){
   	
   	    	super.doActualizar();
   	    	postSucess();
   	    
   	        
   	    	return null;      	
       }
 
 
 public String doBorrar(){
		
	 super.doBorrar();
	 postSucess(); 
	        
	    	return null;    	
 }
 
 
 @SuppressWarnings("unchecked")
public String doEditar(){		
	 setNewEntidad((ENT) tabla.getRowData());
index=tabla.getRowIndex();	 	
	 	return null;    	
	 }
 /**
  * usado en el boton select de cada tabla en el formulario para selcción de entidades
  * @param event
  */
 @SuppressWarnings("unchecked")
public void doSelectListener(ActionEvent event) {
	 
	 String att=(String) event.getComponent().getAttributes().get("attBckBeanOrigen");
	 if(att!=null){
		 setValueExpression(att,(ENT) tabla.getRowData());	
	 }
	   
	}
 
 
 /**
  * 
  * @param event
  */
 @SuppressWarnings("unchecked")
 public void doSelectInListener(ActionEvent event) {
 	 
 	 String att=(String) event.getComponent().getAttributes().get("attBckBeanDestino");
 	 if(att!=null){
 		 setValueExpression(att,(ENT) tabla.getRowData());	
 	 }
 	   
 	}
 /**
  *  creating value expression with the help of the expression factory and the ELContext
  * @param expressionAtt
  * @param value
  */
 public void setValueExpression(String expressionAtt,ENT value){
	 Application app = FacesContext.getCurrentInstance().getApplication();		
	 
	 ExpressionFactory exprFactory = app.getExpressionFactory();
	// getting the ELContext from faces context
	 ELContext elContext = FacesContext.getCurrentInstance().getELContext();
	 // creating value expression with the help of the expression factory and the ELContext

	 ValueExpression valExpr = exprFactory.createValueExpression(elContext, "#{"+ expressionAtt+"}",value.getClass() );
	 valExpr.setValue(elContext,value);
	 

	 
 }
 
 
 @SuppressWarnings({ "rawtypes", "unchecked" })
 public String doGeneraPDF(List<?> list,String nombreReporte){
 	String pathReporte="/reportes/template";//+nombreReporte;
 	//Objeto para parámetros
 	Map parametros = new HashMap();  
 	parametros.put("NOMBRE_REPORTE", "Reporte "+nombreReporte);
 	 
 	 ReportUtils.generarReportePDFLink(pathReporte, list, parametros, "reporte"+nombreReporte);
 	 
 	 return null;
  }
  
  public String doGenerarListXLS(){	 
	  doGeneraXLS(getEntidadLst(), getNewEntidad().getClass().getSimpleName());
 	 return null;
  }
  
  @SuppressWarnings({ "rawtypes", "unchecked" })
  public String doGeneraXLS(List<?> list,String nombreReporte){
  	String pathReporte="/reportes/template";//+nombreReporte;
  	//Objeto para parámetros
  	Map parametros = new HashMap();  
  	parametros.put("NOMBRE_REPORTE", "Reporte "+nombreReporte);
  	 
  	 ReportUtils.generarReporteXLSLink(pathReporte, list, parametros, "reporte"+nombreReporte);
  	 
  	 return null;
   }
   
   public String doGenerarListPDF(){	 
  	 doGeneraPDF(getEntidadLst(), getNewEntidad().getClass().getSimpleName());
  	 return null;
   }

   
   public void doPreProcessPDF(Object document) throws IOException, BadElementException, DocumentException {  
	    Document pdf = (Document) document;  
	    pdf.open();  
	    pdf.setPageSize(PageSize.LETTER);  
	  
	   ServletContext servletContext = FacesUtils.getServletContext();
	    
	    String logo = servletContext.getRealPath("") + File.separator+"resources"+ File.separator + "images" + File.separator + "logo.png";  
	    pdf.addTitle("Reporte "+getNewEntidad().getClass().getSimpleName());
	    pdf.add(Image.getInstance(logo));  
	    /*
	    String title="Reporte "+getEntidad().getClass().getSimpleName();
	    pdf.addHeader(title, title);
	    */
	} 
   public void doPostProcessXLS(Object document) {  
	  HSSFWorkbook wb = (HSSFWorkbook) document;  
	    HSSFSheet sheet = wb.getSheetAt(0);  
	    HSSFRow header = sheet.getRow(0);  
	      
	    HSSFCellStyle cellStyle = wb.createCellStyle();    
	    cellStyle.setFillForegroundColor(HSSFColor.GREEN.index);  
	    cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);  
	      
	    for(int i=0; i < header.getPhysicalNumberOfCells();i++) {  
	        HSSFCell cell = header.getCell(i);  
	          
	        cell.setCellStyle(cellStyle);  
	    }  
	} 
   
   
   
/**
 * @return the entidadLst
 */
public List<ENT> getEntidadLst() {
	return entidadLst;
}

/**
 * @param entidadLst the entidadLst to set
 */
public void setEntidadLst(List<ENT> entidadLst) {
	this.entidadLst = entidadLst;
}
public DataTable getTabla() {
	
	if(tabla==null){
		tabla=new DataTable();
	}
	return tabla;
}
public void setTabla(DataTable tabla) {
	this.tabla = tabla;
}
public int getIndex() {
	return index;
}
public void setIndex(int index) {
	this.index = index;
}

}