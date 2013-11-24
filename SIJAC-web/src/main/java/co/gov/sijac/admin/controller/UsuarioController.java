/*
+ * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package co.gov.sijac.admin.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Produces;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlGraphicImage;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.WebApplicationException;

import co.gov.sijac.admin.enums.EParametrosAdmin;
import co.gov.sijac.admin.facade.UsuarioFacade;
import co.gov.sijac.admin.model.entidades.Perfil;
import co.gov.sijac.admin.model.entidades.Usuario;
import co.gov.sijac.common.controller.GenericoPrimeFacesController;
import co.gov.sijac.common.dto.RequestDTO;
import co.gov.sijac.common.dto.ResponseDTO;
import co.gov.sijac.common.facade.GenericoFacadeInterface;
import co.gov.sijac.common.util.FacesUtils;
import co.gov.sijac.exception.ServicioFacadeExcepcion;
import co.gov.sijac.image.facade.ImagenFacade;
import co.gov.sijac.image.model.entidades.EImagen;
import co.gov.sijac.image.model.entidades.ETipoImagen;
import co.gov.sijac.image.model.entidades.Imagen;
import co.gov.sijac.image.model.enums.ETipoEntidad;
import org.primefaces.model.DualListModel;
import org.richfaces.cdi.push.Push;

// The @Model stereotype is a convenience mechanism to make this a request-scoped bean that has an
// EL name
// Read more about the @Model stereotype in this FAQ:
// http://sfwk.org/Documentation/WhatIsThePurposeOfTheModelAnnotation

@ManagedBean(name ="usuarioController")
@ViewScoped
public class UsuarioController extends GenericoPrimeFacesController<Usuario>{

   //public static final String PUSH_USUARIO_TOPIC = "pushUsuario";
   

    @Inject
    private UsuarioFacade usuarioServicio;
    @Inject
    private ImagenFacade imagenServicio;

   // @Inject
   // @Push(topic = PUSH_USUARIO_TOPIC) Event<String> pushEvent;
    private Usuario usuario;
    
    private List<Perfil> target; 
    private List<Perfil> source;
    private List<String> sourceStr ; 
    private List<String> targetStr ;  
    private Map<Long, Perfil> mapPerfiles;
    private DualListModel<String> perfiles;
    private byte[] dataFotoPerfil;
    
    private String fotoPerfil;
    
    
public UsuarioController() {
    	perfiles=new DualListModel<String>();
		
	}


	@Produces
    @Named
    public Usuario getUsuario() {
        return usuario;
    }

   
    @PostConstruct
    @Override
    public void init() {
        usuario = new Usuario();
    }

	@Override
	public GenericoFacadeInterface<Usuario> getGenericoFacade() {
	return usuarioServicio;
	}

	@Override
	public Usuario getNewEntidad() {		
		return usuario;
	}
	@Override
	public void setNewEntidad(Usuario newEntidad) {		
		this.usuario=newEntidad;
	}
	
	@Override
	public String doActualizar() {
		usuario.setFecCambio(new Date());
	
if(mapPerfiles!=null){	
		
		if(usuario.getPerfiles()!=null){
			usuario.getPerfiles().clear();
		}else{
			usuario.setPerfiles(new ArrayList<Perfil>());	
		}
			 for (String opc : perfiles.getTarget()) {
					
				 long id=Long.valueOf(opc.split("-")[0]);
				 Perfil mapPfl=mapPerfiles.get(id);
				if( mapPfl.getIdPerfil().longValue()==id){	
					usuario.getPerfiles().add(mapPfl);
				}
				} 
		
	 }
	
	
	 super.doActualizar();
		 cargarPerfiles();
		
		return null;
	}

@Override
	public String doCrear() {
	usuario.setFecCambio(new Date());
	usuario.setFecRegistro(new Date());
		return super.doCrear();
		
	}

@Override
	public String doEditar() {
	fotoPerfil=null;
	super.doEditar();
	/*try {
		usuarioServicio.cargarFotoUsuario(usuario);
	} catch (ServicioFacadeExcepcion e) {
	throw new WebApplicationException(e);
	}*/
	cargarPerfiles();
		return null;
		
	}

/**
 * Consulta los perfiles diponebles y libres para el usuario 	
 */
@SuppressWarnings("unchecked")
private void  cargarPerfiles(){
		
		try{
		sourceStr = new ArrayList<String>(); 
	    targetStr = new ArrayList<String>(); 
		 target = new ArrayList<Perfil>(); 	
		 
		 RequestDTO reqDTO=new RequestDTO(context);
		 reqDTO.setEntidadLocal(usuario); 
		 ResponseDTO resp=usuarioServicio.consultarPerfilesDisponibles(reqDTO); 
		 source=(List<Perfil>) resp.getParam(EParametrosAdmin.PerfilesDisponiblesUser); 
		 target=usuario.getPerfiles();
		 
		 mapPerfiles=new HashMap<Long, Perfil>();
		 if(target!=null && !target.isEmpty()){
			
			 for (Perfil perfil : target) {
				 mapPerfiles.put(perfil.getIdPerfil(), perfil);
				 targetStr.add(""+perfil.getIdPerfil()+"-"+perfil.getNombre());
				 
			}
		 }
		 
		 if(source!=null && !source.isEmpty()){
			 
			 for (Perfil perfil : source) {
				 mapPerfiles.put(perfil.getIdPerfil(), perfil);
				 sourceStr.add(""+perfil.getIdPerfil()+"-"+perfil.getNombre());
			}
		 }
	     perfiles= new DualListModel<String>(sourceStr, targetStr);  
		}catch(Exception e){	
			addErrorMessage(e);
		}
		
	}
	
/*
    public Event<String> getPushEvent() {
		return pushEvent;
	}


	public void setPushEvent(Event<String> pushEvent) {
		this.pushEvent = pushEvent;
	}
*/

	public List<Perfil> getTarget() {
		return target;
	}


	public void setTarget(List<Perfil> target) {
		this.target = target;
	}


	public List<Perfil> getSource() {
		return source;
	}


	public void setSource(List<Perfil> source) {
		this.source = source;
	}


	public List<String> getSourceStr() {
		return sourceStr;
	}


	public void setSourceStr(List<String> sourceStr) {
		this.sourceStr = sourceStr;
	}


	public List<String> getTargetStr() {
		return targetStr;
	}


	public void setTargetStr(List<String> targetStr) {
		this.targetStr = targetStr;
	}


	public Map<Long, Perfil> getMapPerfiles() {
		return mapPerfiles;
	}


	public void setMapPerfiles(Map<Long, Perfil> mapPerfiles) {
		this.mapPerfiles = mapPerfiles;
	}


	public DualListModel<String> getPerfiles() {
		return perfiles;
	}


	public void setPerfiles(DualListModel<String> perfiles) {
		this.perfiles = perfiles;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	private void addImagen()  
    {  
    Application application =  FacesUtils.getApplication();  
   
  
      
    HtmlGraphicImage output =   (HtmlGraphicImage)application.  
    createComponent(HtmlGraphicImage.COMPONENT_TYPE);  
    //HtmlOutputText output = (HtmlOutputText)application.  
    //createComponent(HtmlOutputText.COMPONENT_TYPE);  
      
      
    //output.setValue(" " + count + " ");  
      
    output.setUrl("/imgs/1.jgp");   
  
    //output.setStyle("background-color: yellow");  
      
    //output1.setUsemap("/imgs/1.jpg");  
    //output1.setStyle("background-image: url(/imgs/1.jpg)");  
      
     
    }


	public String getFotoPerfil() {
		if(fotoPerfil==null && usuario != null && usuario.getFotoPerfil()!=null){
			fotoPerfil=""+usuario.getFotoPerfil().getIdImagen();
			}
		return fotoPerfil;
	}


	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}


	public byte[] getDataFotoPerfil() {
		return dataFotoPerfil;
	}


	public void setDataFotoPerfil(byte[] dataFotoPerfil) {
		this.dataFotoPerfil = dataFotoPerfil;
		
		if(usuario != null && usuario.getIdUsuario()!=null){
if(usuario.getFotoPerfil()==null){
	Imagen img=new Imagen();
	   img.setIdEntidad(new Long(ETipoEntidad.USER.getId()+""+usuario.getIdUsuario()));
	   img.setNombre(EImagen.FOTO_PERFIL.name());
	   img.setTipo(EImagen.FOTO_PERFIL);
	   img.setFechaRegistro(new Date());
	   img.setExtension(ETipoImagen.jpg);
	   img.setContent(dataFotoPerfil);
	   usuario.setFotoPerfil(img); 
	
}else{
	
	usuario.getFotoPerfil().setContent(dataFotoPerfil);	  
}
doActualizar();
getFotoPerfil();
			
			}
	}
	
	 
   
      
	
}
