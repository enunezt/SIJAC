 
	
package co.gov.sijac.admin.lugares.services;

import co.gov.sijac.admin.lugares.model.LugaresModel;
import co.gov.sijac.common.annotation.Servicio;

import co.gov.sijac.exception.ServicioExcepcion;


@Servicio(clase="LugaresServicio",descripcion="Contrato para la Logica de negocio para lugares")
public interface LugaresServicio extends LugaresModel<ServicioExcepcion>{ 

}