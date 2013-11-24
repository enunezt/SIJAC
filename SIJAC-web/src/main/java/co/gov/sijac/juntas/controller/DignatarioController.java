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
import co.gov.sijac.juntas.facade.DignatarioFacade;
import co.gov.sijac.juntas.model.entidades.Dignatario;

/**
 * 
 * @author ENUNEZT
 */
@ManagedBean(name = "dignatarioController")
@ViewScoped
public class DignatarioController extends
	GenericoPrimeFacesController<Dignatario> {

    @Inject
    private DignatarioFacade dignatarioService;

    @Inject
    private CatalogoFacade catalogoService;
    private Set<CatalogoDetalle> tipoDignatarioItems;
    /**
	 * 
	 */
    // @SuppressWarnings("unused")
    // private static final long serialVersionUID = 1424688172794333819L;
    private Dignatario dignatario;

    public DignatarioController() {

    }

    public Dignatario getDignatario() {
	return dignatario;
    }

    public void setDignatario(Dignatario dignatario) {
	this.dignatario = dignatario;
    }

    @Override
    public GenericoFacadeInterface<Dignatario> getGenericoFacade() {

	return dignatarioService;
    }

    @Override
    public Dignatario getNewEntidad() {
	return dignatario;
    }

    @Override
    public void setNewEntidad(Dignatario newEntidad) {
	this.dignatario = newEntidad;
    }

    @Override
    @PostConstruct
    public void init() {
	dignatario = new Dignatario();
    }
    


    /**
     * @return the tipoDignatarioItems
     */
    @SuppressWarnings("unchecked")
    public Set<CatalogoDetalle> getTipoDignatarioItems() {
	if (tipoDignatarioItems == null) {
	    RequestDTO req = new RequestDTO(getContext());
	    req.setParam(EParametro.Catalogo, 1);
	    try {
		ResponseDTO resp = catalogoService
			.consultarLstCatalogDetalle(req);
		tipoDignatarioItems = (Set<CatalogoDetalle>) resp
			.getParam(EParametro.Set);
	    } catch (ServicioFacadeExcepcion e) {
		addErrorMessage(e);
	    }
	}
	return tipoDignatarioItems;
    }

    /**
     * @param tipoDignatarioItems
     *            the tipoDignatarioItems to set
     */
    public void setTipoDignatarioItems(Set<CatalogoDetalle> tipoDignatarioItems) {
	this.tipoDignatarioItems = tipoDignatarioItems;
    }


}
