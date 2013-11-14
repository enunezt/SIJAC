 
	
package co.gov.sijac.juntas.dao.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import co.gov.sijac.juntas.dao.ComiteDAO;
import co.gov.sijac.juntas.model.entidades.Comite;
import co.gov.sijac.common.annotation.GestorEntidad;
import co.gov.sijac.common.dao.impl.GenericoDAO;

/**
 * Session Bean implementation class ComiteDAO
 */
@Stateless
@Local(ComiteDAO.class)
@GestorEntidad(clase="ComiteDAOImpl",descripcion="Gestiona Comite del sistema")
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class ComiteDAOImpl extends GenericoDAO<Comite> implements ComiteDAO {

	@Inject
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public ComiteDAOImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public EntityManager getEntityManager() {
	return em;
	}

}