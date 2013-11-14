package co.gov.sijac.juntas.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import co.gov.sijac.common.controller.GenericoPrimeFacesController;
import co.gov.sijac.common.facade.GenericoFacadeInterface;
import co.gov.sijac.juntas.facade.PagosAfiliadoFacade;
import co.gov.sijac.juntas.model.entidades.PagosAfiliado;

/**
 * 
 * @author ENUNEZT
 */
@ManagedBean(name = "pagosAfiliadoController")
@ViewScoped
public class PagosAfiliadoController extends
	GenericoPrimeFacesController<PagosAfiliado> {

    @Inject
    private PagosAfiliadoFacade pagosAfiliadoService;

    /**
	 * 
	 */
    // @SuppressWarnings("unused")
    // private static final long serialVersionUID = 1424688172794333819L;
    private PagosAfiliado pagosAfiliado;

    public PagosAfiliadoController() {

    }

    public PagosAfiliado getPagosAfiliado() {
	return pagosAfiliado;
    }

    public void setPagosAfiliado(PagosAfiliado pagosAfiliado) {
	this.pagosAfiliado = pagosAfiliado;
    }

    @Override
    public GenericoFacadeInterface<PagosAfiliado> getGenericoFacade() {

	return pagosAfiliadoService;
    }

    @Override
    public PagosAfiliado getNewEntidad() {
	return pagosAfiliado;
    }

    @Override
    public void setNewEntidad(PagosAfiliado newEntidad) {
	this.pagosAfiliado = newEntidad;
    }

    @Override
    @PostConstruct
    public void initNewEntidad() {
	pagosAfiliado = new PagosAfiliado();
    }

}
