 
	
package co.gov.sijac.admin.lugares.dao.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import co.gov.sijac.admin.lugares.dao.PaisDAO;
import co.gov.sijac.admin.lugares.model.entidades.Pais;
import co.gov.sijac.common.annotation.GestorEntidad;
import co.gov.sijac.common.dao.impl.GenericoDAO;

/**
 * Session Bean implementation class PaisDAO
 */
@Stateless
@Local(PaisDAO.class)
@GestorEntidad(clase="PaisDAOImpl",descripcion="Gestiona Pais del sistema")
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class PaisDAOImpl extends GenericoDAO<Pais> implements PaisDAO {

	@Inject
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public PaisDAOImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public EntityManager getEntityManager() {
	return em;
	}

}