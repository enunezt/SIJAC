 
	
package co.gov.sijac.juntas.facade;


import co.gov.sijac.juntas.model.entidades.Persona;
import co.gov.sijac.common.annotation.ServicioFacade;
import co.gov.sijac.common.facade.GenericoFacadeInterface;


@ServicioFacade(clase="PersonaFacade",descripcion="Contrato de la logica de negocio para la gestion de Personas")
public interface PersonaFacade extends  GenericoFacadeInterface<Persona>{ 	
	
}
