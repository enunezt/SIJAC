 
	
package co.gov.sijac.admin.dao.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import co.gov.sijac.admin.dao.CatalogoDAO;
import co.gov.sijac.admin.model.entidades.Catalogo;
import co.gov.sijac.common.annotation.GestorEntidad;
import co.gov.sijac.common.dao.impl.GenericoDAO;

/**
 * Session Bean implementation class CatalogoDAO
 */
@Stateless
@Local(CatalogoDAO.class)
@GestorEntidad(clase="CatalogoDAOImpl",descripcion="Gestiona Catalogo del sistema")
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class CatalogoDAOImpl extends GenericoDAO<Catalogo> implements CatalogoDAO {

	@Inject
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public CatalogoDAOImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public EntityManager getEntityManager() {
	return em;
	}

}