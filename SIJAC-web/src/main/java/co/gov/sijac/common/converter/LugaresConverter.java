package co.gov.sijac.common.converter;
//import javax.faces.application.FacesMessage;
import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
//import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import co.gov.sijac.admin.lugares.model.entidades.Ciudad;
import co.gov.sijac.admin.lugares.model.entidades.Departamento;
import co.gov.sijac.admin.lugares.model.entidades.Pais;


 
@FacesConverter("lugaresConverter")
public class LugaresConverter implements Converter{
	
	public static Map<Integer,Pais> paisSET=new HashMap<Integer, Pais>();
	public static Map<Integer,Departamento> departamentoSET=new HashMap<Integer, Departamento>();
	public static Map<Integer,Ciudad> ciudadSET=new HashMap<Integer, Ciudad>();
	private static String PAIS="PAIS";
	private static String DEPARTAMENTO="DEPARTAMENTO";
	private static String CIUDAD="CIUDAD";
 
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
		String value) {
		
		if(value==null)
			return null;
 
	String[] strArr=value.split(":");
	
	
	if(PAIS.equals(strArr[0])){
	return	paisSET.get(new Integer(strArr[1]));
		
	}else
		if(DEPARTAMENTO.equals(strArr[0])){
			return	departamentoSET.get(new Integer(strArr[1]));	
		}else
			if(CIUDAD.equals(strArr[0])){
				return	ciudadSET.get(new Integer(strArr[1]));	
			}else{
				return null;
			}
	
			/*	FacesMessage msg = 
				new FacesMessage("URL Conversion error.", 
						"Invalid URL format.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ConverterException(msg);*/

	}
 
	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		
		if(value==null)
			return null;
		
		String retorno=null;
		if(value instanceof Pais){
			Pais pais=(Pais) value;
			if(!paisSET.containsKey(pais.getIdPais()))
			paisSET.put(pais.getIdPais(), pais);			
		
			retorno=PAIS+":"+pais.getIdPais();
		}else
			if(value instanceof Departamento){
				Departamento depto=(Departamento) value;
				if(!departamentoSET.containsKey(depto.getIdDepartamento()))
					departamentoSET.put(depto.getIdDepartamento(), depto);			
			
				retorno=DEPARTAMENTO+":"+depto.getIdDepartamento();
				
			}else if(value instanceof Ciudad){
				Ciudad ciudad=(Ciudad) value;
				if(!ciudadSET.containsKey(ciudad.getIdCiudad()))
					ciudadSET.put(ciudad.getIdCiudad(), ciudad);			
			
				retorno=CIUDAD+":"+ciudad.getIdCiudad();
				
			}else{
				return null;
			}		
	
	
 
		return retorno;
 
	}	
}