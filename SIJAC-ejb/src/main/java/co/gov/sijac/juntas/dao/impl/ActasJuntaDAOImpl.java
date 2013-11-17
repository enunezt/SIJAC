 
	
package co.gov.sijac.juntas.dao.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import co.gov.sijac.juntas.dao.ActasJuntaDAO;
import co.gov.sijac.juntas.model.entidades.ActasJunta;
import co.gov.sijac.common.annotation.GestorEntidad;
import co.gov.sijac.common.dao.impl.GenericoDAO;

/**
 * Session Bean implementation class ActasJuntaDAO
 */
@Stateless
@Local(ActasJuntaDAO.class)
@GestorEntidad(clase="ActasJuntaDAOImpl",descripcion="Gestiona ActasJunta del sistema")
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class ActasJuntaDAOImpl extends GenericoDAO<ActasJunta> implements ActasJuntaDAO {

	@Inject
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public ActasJuntaDAOImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public EntityManager getEntityManager() {
	return em;
	}

}