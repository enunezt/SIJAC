package co.gov.sijac.juntas.controller;

import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import co.gov.sijac.admin.facade.CatalogoFacade;
import co.gov.sijac.admin.lugares.facade.LugaresFacade;
import co.gov.sijac.admin.lugares.model.entidades.Pais;
import co.gov.sijac.admin.model.entidades.CatalogoDetalle;
import co.gov.sijac.common.controller.GenericoPrimeFacesController;
import co.gov.sijac.common.dto.ListaLugaresDTO;
import co.gov.sijac.common.dto.RequestDTO;
import co.gov.sijac.common.dto.ResponseDTO;
import co.gov.sijac.common.enums.EParametro;
import co.gov.sijac.common.facade.GenericoFacadeInterface;
import co.gov.sijac.exception.ServicioFacadeExcepcion;
import co.gov.sijac.juntas.facade.PersonaFacade;
import co.gov.sijac.juntas.model.entidades.Persona;

/**
 * 
 * @author ENUNEZT
 */
@ManagedBean(name = "personaController")
@ViewScoped
public class PersonaController extends GenericoPrimeFacesController<Persona> {

    @Inject
    private PersonaFacade personaService;
    @Inject
    private CatalogoFacade catalogoService;
    private Set<CatalogoDetalle> tipoDocumentoItems;
    @Inject
    private LugaresFacade lugarService;
    private ListaLugaresDTO lugar;
    private Set<CatalogoDetalle> profesionItems;
    // @SuppressWarnings("unused")
    // private static final long serialVersionUID = 1424688172794333819L;
    private Persona persona;

    public PersonaController() {

    }

    public Persona getPersona() {
	return persona;
    }

    public void setPersona(Persona persona) {
	this.persona = persona;
    }

    @Override
    public GenericoFacadeInterface<Persona> getGenericoFacade() {

	return personaService;
    }

    @Override
    public Persona getNewEntidad() {
	return persona;
    }

    @Override
    public void setNewEntidad(Persona newEntidad) {
	this.persona = newEntidad;
    }

    @Override
    @PostConstruct
    public void init() {
	persona = new Persona(true);
    }



    /**
     * @return the tipoDocumentoItems
     */
    @SuppressWarnings("unchecked")
    public Set<CatalogoDetalle> getTipoDocumentoItems() {
	if (tipoDocumentoItems == null) {
	    RequestDTO req = new RequestDTO(getContext());
	    req.setParam(EParametro.Catalogo, 1);
	    try {
		ResponseDTO resp = catalogoService
			.consultarLstCatalogDetalle(req);
		tipoDocumentoItems = (Set<CatalogoDetalle>) resp
			.getParam(EParametro.Set);
	    } catch (ServicioFacadeExcepcion e) {
		addErrorMessage(e);
	    }
	}
	return tipoDocumentoItems;
    }

    /**
     * @param tipoDocumentoItems
     *            the tipoDocumentoItems to set
     */
    public void setTipoDocumentoItems(Set<CatalogoDetalle> tipoDocumentoItems) {
	this.tipoDocumentoItems = tipoDocumentoItems;
    }

    /**
     * @return the lugar
     */
    @SuppressWarnings("unchecked")
    public ListaLugaresDTO getLugar() {

	if (lugar == null) {

	    RequestDTO req = new RequestDTO(getContext());
	    req.setParam(EParametro.Catalogo, 1);
	    try {
		ResponseDTO resp = lugarService.consultarPaises(req);
		lugar = new ListaLugaresDTO();
		lugar.setPaisItems((List<Pais>) resp
			.getParam(EParametro.ResultList));
	    } catch (ServicioFacadeExcepcion e) {
		addErrorMessage(e);
	    }

	}
	return lugar;
    }

    /**
     * @param lugar
     *            the lugar to set
     */
    public void setLugar(ListaLugaresDTO lugar) {
	this.lugar = lugar;
    }
    

    /**
     * @return the profesionItems
     */
    @SuppressWarnings("unchecked")
    public Set<CatalogoDetalle> getProfesionItems() {
	if (profesionItems == null) {
	    RequestDTO req = new RequestDTO(getContext());
	    req.setParam(EParametro.Catalogo, 1);
	    try {
		ResponseDTO resp = catalogoService
			.consultarLstCatalogDetalle(req);
		profesionItems = (Set<CatalogoDetalle>) resp
			.getParam(EParametro.Set);
	    } catch (ServicioFacadeExcepcion e) {
		addErrorMessage(e);
	    }
	}
	return profesionItems;
    }

    /**
     * @param profesionItems
     *            the profesionItems to set
     */
    public void setProfesionItems(Set<CatalogoDetalle> profesionItems) {
	this.profesionItems = profesionItems;
    }


}
