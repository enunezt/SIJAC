package co.gov.sijac.admin.services.users.impl;

import java.util.Map;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import co.gov.sijac.admin.dao.UsuarioDAO;
import co.gov.sijac.admin.model.entidades.Menu;
import co.gov.sijac.admin.model.entidades.Usuario;
import co.gov.sijac.admin.services.users.UserSettingsServicio;
import co.gov.sijac.common.annotation.Servicio;
import co.gov.sijac.common.dto.RequestDTO;
import co.gov.sijac.common.dto.ResponseDTO;
import co.gov.sijac.exception.DAOExcepcion;
import co.gov.sijac.exception.ServicioExcepcion;
@Stateless
@Local(UserSettingsServicio.class)
@Servicio(clase="UserSettingsServicioImpl",descripcion="Logica de negocio para la gestion de usuarios,perfiles y menu")
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class UserSettingsServicioImpl implements UserSettingsServicio{ 

	@Inject
	private UsuarioDAO userDAO;

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ResponseDTO consultarUsuario(RequestDTO request)
			throws ServicioExcepcion {
		
    
		try {
			return userDAO.consultarUsuario(request);
		} catch (DAOExcepcion e) {
			throw new ServicioExcepcion(e);
		} catch (Exception e) {
			throw new ServicioExcepcion(e);
		}
	
		
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ResponseDTO consultarMenu(RequestDTO request)
			throws ServicioExcepcion {		

		try {
			return userDAO.consultarMenu(request);
		} catch (DAOExcepcion e) {
			throw new ServicioExcepcion(e);
		}
		 catch (Exception e) {
				throw new ServicioExcepcion(e);
			}
		
	}

	

}
