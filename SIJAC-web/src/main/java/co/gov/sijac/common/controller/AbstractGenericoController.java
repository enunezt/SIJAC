/*
 * JBoss, Home of Professional Open Source
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
package co.gov.sijac.common.controller;

import java.util.List;

import co.gov.sijac.common.dto.RequestDTO;
import co.gov.sijac.common.dto.ResponseDTO;
import co.gov.sijac.common.enums.EParametro;
import co.gov.sijac.common.facade.GenericoFacadeInterface;

// The @Model stereotype is a convenience mechanism to make this a request-scoped bean that has an
// EL name
// Read more about the @Model stereotype in this FAQ:
// http://sfwk.org/Documentation/WhatIsThePurposeOfTheModelAnnotation

public abstract class AbstractGenericoController<ENT> extends BaseController{

  
    
    //@Inject
    public abstract GenericoFacadeInterface<ENT> getGenericoFacade();
    
    protected List<ENT> entidadLst;

  /*  @Inject
    private MemberRegistration memberRegistration;*/

  

    //@Produces
    public abstract ENT getNewEntidad();
    
    public abstract void setNewEntidad(ENT newEntidad);
    
    public String doCrear() {
        try {
            RequestDTO request=new RequestDTO(context);
            request.setEntidadLocal(getNewEntidad());
        	getGenericoFacade().crear(request);
            addInfoMessage("Registered!", "Registration successful");            
          //  pushEvent.fire(String.format("New member added: %s (id: %d)", newMember.getName(), newMember.getId()));
            
            initNewEntidad();
        } catch (Exception e) {
           addErrorMessage(e);
        }
		return null;
    }
    
    public String doActualizar(){
	
      	 try{
      	RequestDTO request=new RequestDTO(context);
        request.setEntidadLocal(getNewEntidad());
      		getGenericoFacade().actualizar(request);
      	    	//spostSucess();
      	    	addInfoMessage("Registered!","Aculización exitosa!");	
      	    	
      	    	}catch(Exception e){
      	    		addErrorMessage(e);	
      	    	}
      	        
      	    	return null;      	
          }
    
    @SuppressWarnings("unchecked")
	protected String postSucess(){
   	 try{
   	     
   		RequestDTO request=new RequestDTO(context);
   	        request.setEntidadLocal(getNewEntidad()); 
   	        ResponseDTO resp=getGenericoFacade().buscarTodos(request);
  		 entidadLst=(List<ENT>)resp.getParam(EParametro.ResultList);
   		
   	    	}catch(Exception e){
   	    		addErrorMessage(e);	
   	    	}
   	        
   	    	return null;	
   	 }
    
    @SuppressWarnings("unchecked")
	public String doConsultar(){
   	 try{
   	  RequestDTO request=new RequestDTO(context);
	        request.setEntidadLocal(getNewEntidad());
   		 ResponseDTO resp= getGenericoFacade().buscarTodos(request);
   		entidadLst=(List<ENT>) resp.getParam(EParametro.ResultList);
   		addInfoMessage("Consulta exitosa","Consulta exitosa con "+entidadLst.size() +" Registros.");
   		    	
   	    	}catch(Exception e){
   	    		addErrorMessage(e);	
   	    	}
   	        
   	    	return null;	
   	 }
    
    public String doBorrar(){
		
   	 try{
   	  RequestDTO request=new RequestDTO(context);
	        request.setEntidadLocal(getNewEntidad());
   	     getGenericoFacade().eliminar(request);
   	    	//postSucess();
   	    	
   	    	addInfoMessage("Registered!","Borrado exitoso!");
   	    	
   	    	}catch(Exception e){
   	    		addErrorMessage(e);	
   	    	}
   	        
   	    	return null;    	
    }
    
    public String doEditar(){		
    	addInfoMessage("Advertencia","doEditar() no implementado :(");
    		 	return null;    	
    		 }

    //@PostConstruct
    public abstract void initNewEntidad();
    /**   
     * metodo genérico utilizado en la vista al cambiar de pais
     */
   public void paisChange(){
       
   }

   /**   
    * metodo genérico utilizado en la vista al cambiar de pais
    */
   public void departamentoChange(){
       
   }
   /**   
    * metodo genérico utilizado en la vista al cambiar de pais
    */
   public void ciudadChange(){
       
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
}
