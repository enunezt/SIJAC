package co.gov.sijac.admin.facade.impl;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import co.gov.sijac.admin.dao.PerfilDAO;
import co.gov.sijac.admin.facade.PerfilFacade;
import co.gov.sijac.admin.model.entidades.Opcion;
import co.gov.sijac.admin.model.entidades.Perfil;
import co.gov.sijac.common.annotation.ServicioFacade;
import co.gov.sijac.common.dao.GenericoDAOInterface;
import co.gov.sijac.common.dto.RequestDTO;
import co.gov.sijac.common.dto.ResponseDTO;
import co.gov.sijac.common.facade.impl.GenericoDAOFacade;
import co.gov.sijac.exception.DAOExcepcion;
import co.gov.sijac.exception.ServicioFacadeExcepcion;

/**
 * Session Bean implementation class PerfilFacade
 */
@Stateless
@Local(PerfilFacade.class)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@ServicioFacade(clase="PerfilFacadeImpl",descripcion="Centraliza la logica de negocio para la entidad Perfil")
public class PerfilFacadeImpl extends GenericoDAOFacade<Perfil> implements PerfilFacade{

@Inject
	private PerfilDAO servicePerfil;	
	
  	/**
     * Default constructor. 
     */
    public PerfilFacadeImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public GenericoDAOInterface<Perfil> getServiceDAO() {
		return servicePerfil;
	}
	@Override	
	 @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ResponseDTO consultarOpcionesDisponiblesPerfil(RequestDTO request)
				throws ServicioFacadeExcepcion {
			try {
				return servicePerfil.consultarOpcionesDisponiblesPerfil(request);
			} catch (DAOExcepcion e) {
				throw new ServicioFacadeExcepcion(e);
			}
		}
	@Override
	 @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ResponseDTO consultarOpcionesPerfil(RequestDTO request) throws ServicioFacadeExcepcion {
			try {
				return servicePerfil.consultarOpcionesPerfil(request);
			} catch (DAOExcepcion e) {
				throw new ServicioFacadeExcepcion(e);
			}
		}

	
}
