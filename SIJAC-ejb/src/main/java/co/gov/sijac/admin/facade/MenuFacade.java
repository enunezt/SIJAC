package co.gov.sijac.admin.facade;


import co.gov.sijac.admin.model.entidades.Menu;
import co.gov.sijac.common.annotation.ServicioFacade;
import co.gov.sijac.common.facade.GenericoFacadeInterface;


@ServicioFacade(clase="MenuFacade",descripcion="Contrato de la logica de negocio para la gestion de menus")
public interface MenuFacade extends  GenericoFacadeInterface<Menu>{ 	
	
}
