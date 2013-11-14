package co.gov.sijac.juntas.controller;

import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import co.gov.sijac.admin.facade.CatalogoFacade;
import co.gov.sijac.admin.model.entidades.CatalogoDetalle;
import co.gov.sijac.common.controller.GenericoPrimeFacesController;
import co.gov.sijac.common.dto.RequestDTO;
import co.gov.sijac.common.dto.ResponseDTO;
import co.gov.sijac.common.enums.EParametro;
import co.gov.sijac.common.facade.GenericoFacadeInterface;
import co.gov.sijac.exception.ServicioFacadeExcepcion;
import co.gov.sijac.juntas.facade.LibroFacade;
import co.gov.sijac.juntas.model.entidades.Libro;

/**
 * 
 * @author ENUNEZT
 */
@ManagedBean(name = "libroController")
@ViewScoped
public class LibroController extends GenericoPrimeFacesController<Libro> {

    @Inject
    private LibroFacade libroService;

    @Inject
    private CatalogoFacade catalogoService;
    private Set<CatalogoDetalle> comisionTrabajoItems;

    /**
	 * 
	 */
    // @SuppressWarnings("unused")
    // private static final long serialVersionUID = 1424688172794333819L;
    private Libro libro;

    public LibroController() {

    }

    public Libro getLibro() {
	return libro;
    }

    public void setLibro(Libro libro) {
	this.libro = libro;
    }

    @Override
    public GenericoFacadeInterface<Libro> getGenericoFacade() {

	return libroService;
    }

    @Override
    public Libro getNewEntidad() {
	return libro;
    }

    @Override
    public void setNewEntidad(Libro newEntidad) {
	this.libro = newEntidad;
    }

    @Override
    @PostConstruct
    public void initNewEntidad() {
	libro = new Libro();
    }

    /**
     * @return the comisionTrabajoItems
     */
    @SuppressWarnings("unchecked")
    public Set<CatalogoDetalle> getComisionTrabajoItems() {
	if (comisionTrabajoItems == null) {
	    RequestDTO req = new RequestDTO(getContext());
	    req.setParam(EParametro.Catalogo, 1);
	    try {
		ResponseDTO resp = catalogoService
			.consultarLstCatalogDetalle(req);
		comisionTrabajoItems = (Set<CatalogoDetalle>) resp
			.getParam(EParametro.Set);
	    } catch (ServicioFacadeExcepcion e) {
		addErrorMessage(e);
	    }
	}
	return comisionTrabajoItems;
    }

    /**
     * @param comisionTrabajoItems
     *            the comisionTrabajoItems to set
     */
    public void setComisionTrabajoItems(
	    Set<CatalogoDetalle> comisionTrabajoItems) {
	this.comisionTrabajoItems = comisionTrabajoItems;
    }


}
