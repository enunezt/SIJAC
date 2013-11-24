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
import co.gov.sijac.juntas.facade.ComiteFacade;
import co.gov.sijac.juntas.model.entidades.Comite;

/**
 * 
 * @author ENUNEZT
 */
@ManagedBean(name = "comiteController")
@ViewScoped
public class ComiteController extends GenericoPrimeFacesController<Comite> {

    @Inject
    private ComiteFacade comiteService;

    @Inject
    private CatalogoFacade catalogoService;
    private Set<CatalogoDetalle> tipoComiteItems;

    /**
	 * 
	 */
    // @SuppressWarnings("unused")
    // private static final long serialVersionUID = 1424688172794333819L;
    private Comite comite;

    public ComiteController() {

    }

    public Comite getComite() {
	return comite;
    }

    public void setComite(Comite comite) {
	this.comite = comite;
    }

    @Override
    public GenericoFacadeInterface<Comite> getGenericoFacade() {

	return comiteService;
    }

    @Override
    public Comite getNewEntidad() {
	return comite;
    }

    @Override
    public void setNewEntidad(Comite newEntidad) {
	this.comite = newEntidad;
    }

    @Override
    @PostConstruct
    public void init() {
	comite = new Comite();
    }

    /**
     * @return the tipoComiteItems
     */
    @SuppressWarnings("unchecked")
    public Set<CatalogoDetalle> getTipoComiteItems() {
	if (tipoComiteItems == null) {
	    RequestDTO req = new RequestDTO(getContext());
	    req.setParam(EParametro.Catalogo, 1);
	    try {
		ResponseDTO resp = catalogoService
			.consultarLstCatalogDetalle(req);
		tipoComiteItems = (Set<CatalogoDetalle>) resp
			.getParam(EParametro.Set);
	    } catch (ServicioFacadeExcepcion e) {
		addErrorMessage(e);
	    }
	}
	return tipoComiteItems;
    }

    /**
     * @param tipoComiteItems
     *            the tipoComiteItems to set
     */
    public void setTipoComiteItems(Set<CatalogoDetalle> tipoComiteItems) {
	this.tipoComiteItems = tipoComiteItems;
    }


}
