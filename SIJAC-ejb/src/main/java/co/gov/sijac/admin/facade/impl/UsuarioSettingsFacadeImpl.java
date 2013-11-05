package co.gov.sijac.admin.facade.impl;

import java.util.Map;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import co.gov.sijac.admin.facade.UsuarioSettingsFacade;
import co.gov.sijac.admin.model.entidades.Menu;
import co.gov.sijac.admin.model.entidades.Usuario;
import co.gov.sijac.admin.services.users.UserSettingsServicio;
import co.gov.sijac.common.annotation.ServicioFacade;
import co.gov.sijac.common.dto.RequestDTO;
import co.gov.sijac.common.dto.ResponseDTO;
import co.gov.sijac.exception.ServicioExcepcion;
import co.gov.sijac.exception.ServicioFacadeExcepcion;

/**
 * Session Bean implementation class UsuarioSettingsFacadeImpl
 */

@Stateless
@Local(UsuarioSettingsFacade.class)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@ServicioFacade(clase="UsuarioSettingsFacadeImpl",descripcion="Centraliza la logica de negocio para la gestion de usuarios, perfiles y menu")
public class UsuarioSettingsFacadeImpl implements UsuarioSettingsFacade{

   @Inject
   private UserSettingsServicio userSrv;
	
	/**
     * Default constructor. 
     */
    public UsuarioSettingsFacadeImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ResponseDTO consultarMenu(RequestDTO request)
			throws ServicioFacadeExcepcion {
		
		try {
			return userSrv.consultarMenu(request);
		} catch (ServicioExcepcion e) {
		throw new ServicioFacadeExcepcion(e);
		}
	}

	@Override
	public ResponseDTO consultarUsuario(RequestDTO request)
			throws ServicioFacadeExcepcion {
	
		try {
			return userSrv.consultarUsuario(request);
		} catch (ServicioExcepcion e) {
			throw new ServicioFacadeExcepcion(e);
		}
	}

	

}
