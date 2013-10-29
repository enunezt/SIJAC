package co.gov.sijac.admin.dao.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import co.gov.sijac.admin.dao.MenuDAO;
import co.gov.sijac.admin.model.entidades.Menu;
import co.gov.sijac.common.annotation.GestorEntidad;
import co.gov.sijac.common.dao.impl.GenericoDAO;

/**
 * Session Bean implementation class GEUsuario
 */
@Stateless
@Local(MenuDAO.class)
@GestorEntidad(clase="MenuDAOImpl",descripcion="Gestiona los Menus del sistema")
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class MenuDAOImpl extends GenericoDAO<Menu> implements MenuDAO {

	@Inject
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public MenuDAOImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public EntityManager getEntityManager() {
	return em;
	}

}