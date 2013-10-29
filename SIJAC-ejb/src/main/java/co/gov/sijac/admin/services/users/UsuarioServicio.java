package co.gov.sijac.admin.services.users;

import co.gov.sijac.common.annotation.Servicio;
import co.gov.sijac.common.dto.RequestDTO;
import co.gov.sijac.common.dto.ResponseDTO;
import co.gov.sijac.exception.ServicioExcepcion;


@Servicio(clase="UsuarioServicio",descripcion="Contrato para la Logica de negocio para Usuarios")
public interface UsuarioServicio {


	/**
	 * /**
	 * Carga foto a la entidad Usuario 
	 * @param rquest Usuario en RequestDTO.EntidadLocal
	 * @return Usuario en ResponseDTO.EntidadLocal
	 * @throws E
	 */
	public ResponseDTO cargarFotoUsuario(RequestDTO request) throws ServicioExcepcion;
}
