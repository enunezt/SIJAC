 
	
package co.gov.sijac.juntas.facade;


import co.gov.sijac.juntas.model.entidades.Junta;
import co.gov.sijac.common.annotation.ServicioFacade;
import co.gov.sijac.common.facade.GenericoFacadeInterface;


@ServicioFacade(clase="JuntaFacade",descripcion="Contrato de la logica de negocio para la gestion de Juntas")
public interface JuntaFacade extends  GenericoFacadeInterface<Junta>{ 	
	
}
