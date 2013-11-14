package co.gov.sijac.juntas.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import co.gov.sijac.admin.lugares.facade.LugaresFacade;
import co.gov.sijac.admin.lugares.model.entidades.Ciudad;
import co.gov.sijac.admin.lugares.model.entidades.Departamento;
import co.gov.sijac.common.controller.GenericoPrimeFacesController;
import co.gov.sijac.common.dto.ListaLugaresDTO;
import co.gov.sijac.common.dto.RequestDTO;
import co.gov.sijac.common.dto.ResponseDTO;
import co.gov.sijac.common.enums.EParametro;
import co.gov.sijac.common.facade.GenericoFacadeInterface;
import co.gov.sijac.exception.ServicioFacadeExcepcion;
import co.gov.sijac.juntas.facade.JuntaFacade;
import co.gov.sijac.juntas.model.entidades.Junta;

/**
 * 
 * @author ENUNEZT
 */
@ManagedBean(name = "juntaController")
@ViewScoped
public class JuntaController extends GenericoPrimeFacesController<Junta> {

    @Inject
    private JuntaFacade juntaService;

    @Inject
    private LugaresFacade lugarService;
    private ListaLugaresDTO lugar;
    private Junta junta;
    

    public JuntaController() {

    }

    public Junta getJunta() {
	return junta;
    }

    public void setJunta(Junta junta) {
	this.junta = junta;
    }

    @Override
    public GenericoFacadeInterface<Junta> getGenericoFacade() {

	return juntaService;
    }

    @Override
    public Junta getNewEntidad() {
	return junta;
    }

    @Override
    public void setNewEntidad(Junta newEntidad) {
	this.junta = newEntidad;
    }

    @Override
    @PostConstruct
    public void initNewEntidad() {
	junta = new Junta(true);
    }


    /**
     * @return the lugar
     */
    @SuppressWarnings("unchecked")
    public ListaLugaresDTO getLugar() {

	if (lugar == null) {

	    RequestDTO req = new RequestDTO(getContext());
	    req.setParam( EParametro.IdEntidad , ID_PAIS_COL);
	    try {
		ResponseDTO resp = lugarService.consultarDepartamentos(req);
		lugar = new ListaLugaresDTO();
		lugar.setDeptoItems((List<Departamento>) resp
			.getParam(EParametro.ResultList));
	    } catch (ServicioFacadeExcepcion e) {
		addErrorMessage(e);
	    }

	}
	return lugar;
    }
    
    /**   
     * metodo genérico utilizado en la vista al cambiar de pais
     */
    @SuppressWarnings("unchecked")
    public void departamentoChange(){
	
	if(junta.getCiudad().getDepartamento()!=null){   
	
	 RequestDTO req = new RequestDTO(getContext());
	    req.setParam( EParametro.IdEntidad , junta.getCiudad().getDepartamento().getIdDepartamento());
	    try {
		ResponseDTO resp = lugarService.consultarCiudades(req);
		lugar.setCiudadItems((List<Ciudad>) resp
			.getParam(EParametro.ResultList));
	    } catch (ServicioFacadeExcepcion e) {
		addErrorMessage(e);
	    }}else{
		 lugar.setCiudadItems(null);
	    }
        
    }

    /**
     * @param lugar
     *            the lugar to set
     */
    public void setLugar(ListaLugaresDTO lugar) {
	this.lugar = lugar;
    }

}
