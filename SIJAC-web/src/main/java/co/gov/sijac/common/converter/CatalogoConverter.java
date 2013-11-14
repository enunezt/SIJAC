package co.gov.sijac.common.converter;

import java.util.Date;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import co.gov.sijac.admin.model.entidades.Catalogo;
import co.gov.sijac.admin.model.entidades.CatalogoDetalle;


 
@FacesConverter("catalogoConverter")
public class CatalogoConverter implements Converter{
	

 
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
		String value) {
		
		if(value==null)
			return null;
 
	String[] strArr=value.split("::");
	
	CatalogoDetalle  catH=new CatalogoDetalle();
	
	catH.setCodigo(strArr[0]);
	catH.setIdCatalogoDetalle(Integer.getInteger(strArr[1]));
	catH.setDescripcion(strArr[2]);
	catH.setEstado(strArr[3]);
	catH.setValor(strArr[4]);
	catH.setFechaCambio(new Date(Long.parseLong(strArr[5])));
	catH.setValor(strArr[6]);
	Catalogo catP=new Catalogo();
	catP.setIdCatalogo(Integer.getInteger(strArr[7]));
	catP.setNombre(strArr[8]);
	catH.setCatalogo(catP);
	
	return catH;

	}
 
	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		
		if(value==null)
			return null;
		
	
		
		StringBuilder str = new StringBuilder();
		
	CatalogoDetalle  cat=(CatalogoDetalle) value;
	
	str.append(cat.getCodigo()+"::")
	.append(cat.getIdCatalogoDetalle()+"::")
	.append(cat.getDescripcion()+"::")
	.append(cat.getEstado()+"::")
	.append(cat.getValor()+"::")
	.append(cat.getFechaCambio().getTime()+"::")
	.append(cat.getValor()+"::")
	.append(cat.getCatalogo().getIdCatalogo()+"::")
	.append(cat.getCatalogo().getNombre()+"::");
	
		return str.toString();
 
	}	
}