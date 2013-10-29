package co.gov.sijac.admin.services.users;

import co.gov.sijac.admin.model.UsuarioSettingsModel;
import co.gov.sijac.common.annotation.Servicio;
import co.gov.sijac.exception.ServicioExcepcion;


@Servicio(clase="UserSettingsServicio",descripcion="Contrato para la Logica de negocio para la gestion de usuarios,perfiles y menu")
public interface UserSettingsServicio extends UsuarioSettingsModel<ServicioExcepcion>{

}
