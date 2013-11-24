 
package co.gov.sijac.admin.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import co.gov.sijac.admin.facade.CatalogoFacade;
import co.gov.sijac.admin.model.entidades.Catalogo;
import co.gov.sijac.common.controller.GenericoPrimeFacesController;
import co.gov.sijac.common.facade.GenericoFacadeInterface;
/**
 *
 * @author ENUNEZT
 */
@ManagedBean(name ="catalogoController")
@ViewScoped
public class CatalogoController extends GenericoPrimeFacesController<Catalogo>{
	
	@Inject
	private CatalogoFacade catalogoService;
	
  /**
	 * 
	 */
	//@SuppressWarnings("unused")
	//private static final long serialVersionUID = 1424688172794333819L;
	private Catalogo catalogo;

    public CatalogoController() {    	
     
    }
  
	public Catalogo getCatalogo() {
		return catalogo;
	}
	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}


	@Override
	public GenericoFacadeInterface<Catalogo> getGenericoFacade() {
	
		return catalogoService;
	}


	@Override
	public Catalogo getNewEntidad() {
			return catalogo;
	}
	@Override
	public void setNewEntidad(Catalogo newEntidad) {		
		this.catalogo=newEntidad;
	}


	@Override
	@PostConstruct
	public void init() {
		catalogo= new Catalogo();
	}

		}
	