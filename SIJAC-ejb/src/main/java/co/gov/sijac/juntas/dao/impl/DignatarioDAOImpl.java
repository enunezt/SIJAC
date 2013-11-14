 
	
package co.gov.sijac.juntas.dao.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import co.gov.sijac.juntas.dao.DignatarioDAO;
import co.gov.sijac.juntas.model.entidades.Dignatario;
import co.gov.sijac.common.annotation.GestorEntidad;
import co.gov.sijac.common.dao.impl.GenericoDAO;

/**
 * Session Bean implementation class DignatarioDAO
 */
@Stateless
@Local(DignatarioDAO.class)
@GestorEntidad(clase="DignatarioDAOImpl",descripcion="Gestiona Dignatario del sistema")
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class DignatarioDAOImpl extends GenericoDAO<Dignatario> implements DignatarioDAO {

	@Inject
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public DignatarioDAOImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public EntityManager getEntityManager() {
	return em;
	}

}