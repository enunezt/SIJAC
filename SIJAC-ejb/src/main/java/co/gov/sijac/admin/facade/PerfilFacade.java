package co.gov.sijac.admin.facade;

import co.gov.sijac.admin.model.entidades.Perfil;
import co.gov.sijac.common.annotation.ServicioFacade;
import co.gov.sijac.common.dto.RequestDTO;
import co.gov.sijac.common.dto.ResponseDTO;
import co.gov.sijac.common.facade.GenericoFacadeInterface;
import co.gov.sijac.exception.ServicioFacadeExcepcion;


@ServicioFacade(clase="PerfilFacade",descripcion="Contrato de la logica de negocio para la entidad Perfil")
public interface PerfilFacade extends  GenericoFacadeInterface<Perfil> { 
    /**
     * Consulta las opciones de Diponibles del perfil
     * 
     * @param request
     *            Perfil en RequestDTO.EntidadLocal
     * @return List<Opcion> en parametro EParametro.ResultList
     * @throws ServicioFacadeExcepcion
     */
	public ResponseDTO consultarOpcionesDisponiblesPerfil(RequestDTO request) throws ServicioFacadeExcepcion;
	/**
	 * Consulta las opciones asignadas al perfil
	 * @param perfil Perfil en RequestDTO.EntidadLocal
	 * @return List<Opcion> en parametro EParametro.ResultList
	 * @throws ServicioFacadeExcepcion
	 **/
	public ResponseDTO consultarOpcionesPerfil(RequestDTO request) throws ServicioFacadeExcepcion;

}
