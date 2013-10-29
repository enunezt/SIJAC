package co.gov.sijac.admin.facade.impl;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import co.gov.sijac.admin.dao.UsuarioDAO;
import co.gov.sijac.admin.facade.UsuarioFacade;
import co.gov.sijac.admin.model.entidades.Menu;
import co.gov.sijac.admin.model.entidades.Perfil;
import co.gov.sijac.admin.model.entidades.Usuario;
import co.gov.sijac.admin.services.users.UsuarioServicio;
import co.gov.sijac.common.annotation.ServicioFacade;
import co.gov.sijac.common.dao.GenericoDAOInterface;
import co.gov.sijac.common.dto.RequestDTO;
import co.gov.sijac.common.dto.ResponseDTO;
import co.gov.sijac.common.facade.impl.GenericoDAOFacade;
import co.gov.sijac.exception.DAOExcepcion;
import co.gov.sijac.exception.ServicioExcepcion;
import co.gov.sijac.exception.ServicioFacadeExcepcion;

/**
 * Session Bean implementation class PerfilFacade
 */
@Stateless
@Local(UsuarioFacade.class)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@ServicioFacade(clase="UsuarioFacadeImpl",descripcion="Centraliza la logica de negocio para la entidad Usuario")
public class UsuarioFacadeImpl extends GenericoDAOFacade<Usuario> implements UsuarioFacade{

@Inject
	private UsuarioDAO usuarioDAO;	

@Inject
private UsuarioServicio usuarioServicio;	
	
  	/**
     * Default constructor. 
     */
    public UsuarioFacadeImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public GenericoDAOInterface<Usuario> getServiceDAO() {
		return usuarioDAO;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ResponseDTO consultarPerfilesDisponibles(RequestDTO request)
			throws ServicioFacadeExcepcion {
		
		try {
			return usuarioDAO.consultarPerfilesDisponibles(request);
		} catch (DAOExcepcion e) {
			throw new ServicioFacadeExcepcion(e);
		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ResponseDTO consultarPerfilesUsuario(RequestDTO request)
			throws ServicioFacadeExcepcion {
		
		try {
			return usuarioDAO.consultarPerfilesUsuario(request);
		} catch (DAOExcepcion e) {
			throw new ServicioFacadeExcepcion(e);
		}
	}

	@Override
	public ResponseDTO cargarFotoUsuario(RequestDTO request)
			throws ServicioFacadeExcepcion {
		try {
			return usuarioServicio.cargarFotoUsuario(request);
		} catch (ServicioExcepcion e) {
			throw new ServicioFacadeExcepcion(e);
		}
	}

	
	
}
