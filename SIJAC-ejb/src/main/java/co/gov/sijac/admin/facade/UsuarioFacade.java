package co.gov.sijac.admin.facade;

import co.gov.sijac.admin.model.UsuarioModel;
import co.gov.sijac.admin.model.entidades.Usuario;
import co.gov.sijac.common.annotation.ServicioFacade;
import co.gov.sijac.common.dto.RequestDTO;
import co.gov.sijac.common.dto.ResponseDTO;
import co.gov.sijac.common.facade.GenericoFacadeInterface;
import co.gov.sijac.exception.ServicioFacadeExcepcion;


@ServicioFacade(clase="UsuarioFacade",descripcion="Contrato de la logica de negocio para la gestion de usuarios")
public interface UsuarioFacade extends  GenericoFacadeInterface<Usuario>,UsuarioModel<ServicioFacadeExcepcion>{ 	
	/**
	 * Carga foto a la entidad Usuario 
	 * @param rquest Usuario en RequestDTO.EntidadLocal
	 * @return Usuario en ResponseDTO.EntidadLocal
	 * @throws E
	 */
	public ResponseDTO cargarFotoUsuario(RequestDTO request) throws ServicioFacadeExcepcion;
}
