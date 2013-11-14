 
	
package co.gov.sijac.juntas.facade;


import co.gov.sijac.juntas.model.entidades.Libro;
import co.gov.sijac.common.annotation.ServicioFacade;
import co.gov.sijac.common.facade.GenericoFacadeInterface;


@ServicioFacade(clase="LibroFacade",descripcion="Contrato de la logica de negocio para la gestion de Libros")
public interface LibroFacade extends  GenericoFacadeInterface<Libro>{ 	
	
}
