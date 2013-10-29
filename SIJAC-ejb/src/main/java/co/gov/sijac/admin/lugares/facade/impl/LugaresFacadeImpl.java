 
	
package co.gov.sijac.admin.lugares.facade.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import co.gov.sijac.admin.lugares.dao.PaisDAO;
import co.gov.sijac.admin.lugares.facade.LugaresFacade;
import co.gov.sijac.admin.lugares.model.entidades.Pais;
import co.gov.sijac.admin.lugares.services.LugaresServicio;
import co.gov.sijac.common.annotation.ServicioFacade;
import co.gov.sijac.common.dto.RequestDTO;
import co.gov.sijac.common.dto.ResponseDTO;
import co.gov.sijac.exception.ServicioExcepcion;
import co.gov.sijac.exception.ServicioFacadeExcepcion;
/**
 * Session Bean implementation class PaisFacade
 */
@Stateless
@Local(LugaresFacade.class)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@ServicioFacade(clase="PaisFacadeImpl",descripcion="Centraliza la logica de negocio para la entidad Pais")
public class LugaresFacadeImpl implements LugaresFacade{

	@Inject
	private LugaresServicio serviceLugar;	
	
  	/**
     * Default constructor. 
     */
    public LugaresFacadeImpl() {
        // TODO Auto-generated constructor stub
    }

	/* (non-Javadoc)
	 * @see co.gov.sijac.admin.lugares.model.LugaresModel#consultarPaises(co.gov.sijac.common.dto.RequestDTO)
	 */
	@Override
	public ResponseDTO consultarPaises(RequestDTO request)
		throws ServicioFacadeExcepcion {
	    try {
		  return serviceLugar.consultarPaises(request);
	    } catch (ServicioExcepcion e) {
		throw new ServicioFacadeExcepcion(e);
	    }
	}

	/* (non-Javadoc)
	 * @see co.gov.sijac.admin.lugares.model.LugaresModel#consultarDepartamentos(co.gov.sijac.common.dto.RequestDTO)
	 */
	@Override
	public ResponseDTO consultarDepartamentos(RequestDTO request)
		throws ServicioFacadeExcepcion {
	    try {
		  return serviceLugar.consultarDepartamentos(request);
	    } catch (ServicioExcepcion e) {
		throw new ServicioFacadeExcepcion(e);
	    }
	}

	/* (non-Javadoc)
	 * @see co.gov.sijac.admin.lugares.model.LugaresModel#consultarCiudades(co.gov.sijac.common.dto.RequestDTO)
	 */
	@Override
	public ResponseDTO consultarCiudades(RequestDTO request)
		throws ServicioFacadeExcepcion {
	    try {
		  return  serviceLugar.consultarCiudades(request);
	    } catch (ServicioExcepcion e) {
		throw new ServicioFacadeExcepcion(e);
	    }
	}

	/* (non-Javadoc)
	 * @see co.gov.sijac.admin.lugares.model.LugaresModel#consultarComunas(co.gov.sijac.common.dto.RequestDTO)
	 */
	@Override
	public ResponseDTO consultarComunas(RequestDTO request)
		throws ServicioFacadeExcepcion {
	    try {
		  return serviceLugar.consultarComunas(request);
	    } catch (ServicioExcepcion e) {
		throw new ServicioFacadeExcepcion(e);
	    }
	}

	/* (non-Javadoc)
	 * @see co.gov.sijac.admin.lugares.model.LugaresModel#consultarBarrios(co.gov.sijac.common.dto.RequestDTO)
	 */
	@Override
	public ResponseDTO consultarBarrios(RequestDTO request)
		throws ServicioFacadeExcepcion {
	    try {
		  return serviceLugar.consultarBarrios(request);
	    } catch (ServicioExcepcion e) {
		throw new ServicioFacadeExcepcion(e);
	    }
	  
	}

	
	
}