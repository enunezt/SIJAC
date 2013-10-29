package co.gov.sijac.admin.dao;

import java.util.List;

import co.gov.sijac.admin.model.entidades.Opcion;
import co.gov.sijac.admin.model.entidades.Perfil;
import co.gov.sijac.common.annotation.GestorEntidad;
import co.gov.sijac.common.dao.GenericoDAOInterface;
import co.gov.sijac.common.dto.RequestDTO;
import co.gov.sijac.common.dto.ResponseDTO;
import co.gov.sijac.exception.DAOExcepcion;

@GestorEntidad(clase="PerfilDAO",descripcion="Interfaz los perfiles del sistema")
public interface PerfilDAO extends GenericoDAOInterface<Perfil> {

	/**
	 * Consulta las opciones de Diponibles del perfil
	 * @param request Perfil en RequestDTO.EntidadLocal
	 * @return List<Opcion> en parametro EParametro.ResultList
	 * @throws DAOExcepcion
	 */
	public ResponseDTO consultarOpcionesDisponiblesPerfil(RequestDTO request) throws DAOExcepcion;
	
	/**
	 * Consulta las opciones asignadas al perfil
	 * @param perfil Perfil en RequestDTO.EntidadLocal
	 * @return List<Opcion> en parametro EParametro.ResultList
	 * @throws DAOExcepcion
	 */
	public ResponseDTO consultarOpcionesPerfil(RequestDTO request) throws DAOExcepcion;;
	
}
