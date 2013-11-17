 
package co.gov.sijac.juntas.controller;

import java.util.Set;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import co.gov.sijac.juntas.facade.ActasJuntaFacade;
import co.gov.sijac.juntas.model.entidades.ActasJunta;
import co.gov.sijac.common.controller.GenericoPrimeFacesController;
import co.gov.sijac.common.facade.GenericoFacadeInterface;

import co.gov.sijac.admin.facade.CatalogoFacade;
import co.gov.sijac.admin.lugares.facade.LugaresFacade;
import co.gov.sijac.admin.lugares.model.entidades.Pais;
import co.gov.sijac.admin.lugares.model.entidades.Departamento;
import co.gov.sijac.admin.lugares.model.entidades.Ciudad;
import co.gov.sijac.admin.model.entidades.CatalogoDetalle;
import co.gov.sijac.exception.ServicioFacadeExcepcion;
import co.gov.sijac.common.dto.RequestDTO;
import co.gov.sijac.common.dto.ResponseDTO;
import co.gov.sijac.common.enums.EParametro;
import co.gov.sijac.common.dto.ListaLugaresDTO;
/**
 *
 * @author ENUNEZT
 */
@ManagedBean(name ="actasJuntaController")
@ViewScoped
public class ActasJuntaController extends GenericoPrimeFacesController<ActasJunta>{
	
	@Inject
	private ActasJuntaFacade actasJuntaService;
	
	 			
	 			
	 			
	 			
	 			
	@Inject
private CatalogoFacade catalogoService;
private Set<CatalogoDetalle>	 tipoActaItems;
/**
 * @return the tipoActaItems
 */
@SuppressWarnings("unchecked")
public Set<CatalogoDetalle> gettipoActaItems() {
    if(tipoActaItems==null){
	RequestDTO req=new RequestDTO(getContext()) ;
	req.setParam(EParametro.Catalogo, 1);
	try {
	  ResponseDTO resp=  catalogoService.consultarLstCatalogDetalle(req);
	  tipoActaItems=(Set<CatalogoDetalle>) resp.getParam(EParametro.Set);
	} catch (ServicioFacadeExcepcion e) {
	   addErrorMessage(e);
	}
    }
    return tipoActaItems;
}

/**
 * @param tipoActaItems the tipoActaItems to set
 */
public void settipoActaItems(Set<CatalogoDetalle> tipoActaItems) {
    this.tipoActaItems = tipoActaItems;
}

	 			
	
	
  /**
	 * 
	 */
	//@SuppressWarnings("unused")
	//private static final long serialVersionUID = 1424688172794333819L;
	private ActasJunta actasJunta;

    public ActasJuntaController() {    	
     
    }
  
	public ActasJunta getActasJunta() {
		return actasJunta;
	}
	public void setActasJunta(ActasJunta actasJunta) {
		this.actasJunta = actasJunta;
	}


	@Override
	public GenericoFacadeInterface<ActasJunta> getGenericoFacade() {
	
		return actasJuntaService;
	}


	@Override
	public ActasJunta getNewEntidad() {
			return actasJunta;
	}
	@Override
	public void setNewEntidad(ActasJunta newEntidad) {		
		this.actasJunta=newEntidad;
	}


	@Override
	@PostConstruct
	public void initNewEntidad() {
		actasJunta= new ActasJunta();
	}

		}
	