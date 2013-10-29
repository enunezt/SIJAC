package co.gov.sijac.admin.facade.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import co.gov.sijac.admin.dao.MenuDAO;
import co.gov.sijac.admin.facade.MenuFacade;
import co.gov.sijac.admin.model.entidades.Menu;
import co.gov.sijac.common.annotation.ServicioFacade;
import co.gov.sijac.common.dao.GenericoDAOInterface;
import co.gov.sijac.common.facade.impl.GenericoDAOFacade;

/**
 * Session Bean implementation class PerfilFacade
 */
@Stateless
@Local(MenuFacade.class)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@ServicioFacade(clase="MenuFacadeImpl",descripcion="Centraliza la logica de negocio para la entidad Menu")
public class MenuFacadeImpl extends GenericoDAOFacade<Menu> implements MenuFacade{

@Inject
	private MenuDAO serviceMenu;	
	
  	/**
     * Default constructor. 
     */
    public MenuFacadeImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public GenericoDAOInterface<Menu> getServiceDAO() {
		return serviceMenu;
	}

	

	
	
}
