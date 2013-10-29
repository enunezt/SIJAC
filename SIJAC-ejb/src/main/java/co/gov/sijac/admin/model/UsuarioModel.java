package co.gov.sijac.admin.model;

import co.gov.sijac.common.dto.RequestDTO;
import co.gov.sijac.common.dto.ResponseDTO;
import co.gov.sijac.exception.DAOExcepcion;

public interface UsuarioModel<E  extends Exception> {
	/**
	 * Consulta los perfiles disponibles del usuario que pasa como parametro
	 * @param usuario Usuario en RequestDTO.EntidadLocal
	 * @return  List<Perfil> en parametro EParametrosAdmin.PerfilesDisponiblesUser
	 * @throws DAOExcepcion
	 */
	public ResponseDTO consultarPerfilesDisponibles(RequestDTO usuario) throws E;
	
	/**
	 * Consulta los perfiles del usuario 
	 * @param usuario Usuario en RequestDTO.EntidadLocal
	 * @return Map<String,Menu>   en parametro EParametrosAdmin.PerfilesUser
	 * @throws DAOExcepcion
	 */
	public ResponseDTO consultarPerfilesUsuario(RequestDTO usuario) throws E;

	
}
