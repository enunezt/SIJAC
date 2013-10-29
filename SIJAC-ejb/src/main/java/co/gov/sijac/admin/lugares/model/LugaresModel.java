/**
 * 
 */
package co.gov.sijac.admin.lugares.model;

import co.gov.sijac.common.dto.RequestDTO;
import co.gov.sijac.common.dto.ResponseDTO;

/**
 * @author enunezt
 *
 */
public interface LugaresModel<E  extends Exception> {
    
    /**
	 * Consulta el listado de paises con sus respectivos deparatamentos
	 * @param request 
	 * @return List<Pais> en parametro EParametro.ResultList
	 * @throws E
	 */
	public ResponseDTO consultarPaises(RequestDTO request) throws E;
	
	/**
	 * Consulta el listado de Deparatamentos cons sus repsectivas ciudades
	 * @param request idPais en EParametro.IdEntidad (Pais) 
	 * @return List<Departamento> en parametro EParametro.ResultList
	 * @throws E
	 */	
	public ResponseDTO consultarDepartamentos(RequestDTO request) throws E;
	
	
	/**
	 * Consulta el listado de Ciudades
	 * @param request idDepartamento en EParametro.IdEntidad (Departamento)
	 * @return List<Ciudad> en parametro EParametro.ResultList
	 * @throws E
	 */
	public ResponseDTO consultarCiudades(RequestDTO request) throws E;
	/**
	 * Consulta el listado de comunas de una ciudad
	 * @param request idCiudad en EParametro.IdEntidad (Integer)
	 * @return List<?> en parametro EParametro.ResultList
	 * @throws E
	 */
	public ResponseDTO consultarComunas(RequestDTO request) throws E;
	
	/**
	 *  Consulta el listado de barrios de una ciudad
	 * @param request idCiudad en EParametro.IdEntidad (Integer)
	 * @return  List<?> en parametro EParametro.ResultList
	 * @throws E
	 */
	public ResponseDTO consultarBarrios(RequestDTO request) throws E;
	


}
