package co.gov.sijac.admin.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import co.gov.sijac.admin.facade.OpcionFacade;
import co.gov.sijac.admin.model.entidades.Opcion;
import co.gov.sijac.common.controller.GenericoPrimeFacesController;
import co.gov.sijac.common.facade.GenericoFacadeInterface;

/**
 *
 * @author ENUNEZT
 */

@ManagedBean(name ="opcionController")
@ViewScoped
public class OpcionController extends GenericoPrimeFacesController<Opcion>{
	@Inject
	private OpcionFacade opcionService;
	
  
private Opcion opcion;
    public OpcionController() {
    	
        
    }
	public Opcion getOpcion() {
		return opcion;
	}
	public void setOpcion(Opcion opcion) {
		this.opcion = opcion;
	}


	@Override
	public GenericoFacadeInterface<Opcion> getGenericoFacade() {
	
		return opcionService;
	}


	@Override
	public Opcion getNewEntidad() {
			return opcion;
	}
	@Override
	public void setNewEntidad(Opcion newEntidad) {		
		this.opcion=newEntidad;
	}


	@Override
	@PostConstruct
	public void init() {
		opcion= new Opcion();
	}
	
		}
	