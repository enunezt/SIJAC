 
	
package co.gov.sijac.admin.lugares.facade;


import co.gov.sijac.admin.lugares.model.LugaresModel;
import co.gov.sijac.common.annotation.ServicioFacade;
import co.gov.sijac.exception.ServicioFacadeExcepcion;


@ServicioFacade(clase="PaisFacade",descripcion="Contrato de la logica de negocio para la gestion de Lugares")
public interface LugaresFacade extends  LugaresModel<ServicioFacadeExcepcion>{ 
    
	
}
