package co.gov.sijac.admin.facade;

import co.gov.sijac.admin.model.UsuarioSettingsModel;
import co.gov.sijac.common.annotation.ServicioFacade;
import co.gov.sijac.exception.ServicioFacadeExcepcion;


@ServicioFacade(clase="UsuarioSettingsFacade",descripcion="Contrato de la logica de negocio para la gestion de usuarios, perfiles y menu")
public interface UsuarioSettingsFacade extends UsuarioSettingsModel<ServicioFacadeExcepcion> { 	
	
}
