package co.gov.sijac.admin.model;

import co.gov.sijac.common.dto.RequestDTO;
import co.gov.sijac.common.dto.ResponseDTO;
import co.gov.sijac.exception.DAOExcepcion;

public interface UsuarioSettingsModel<E extends Exception> { 	
	/**
	 * Consulta login de usuario
	 * @param request Usuario en RequestDTO.EntidadLocal
	 * @return Map<Long, Menu> en parametro EParametro.Map
	 * @throws E
	 */	
	public ResponseDTO consultarMenu(RequestDTO request) throws E;	
	
	
	/**
	 * Cosnulta Menu del usuario
	 * @param request Usuario en RequestDTO.EntidadLocal
	 * @return Usuario en parametro ResponseDTO.EntidadLocal
	 * @throws DAOExcepcion
	 */
	public ResponseDTO consultarUsuario(RequestDTO request /*String usuario, String pass*/)
			throws E;

}