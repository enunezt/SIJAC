 
	
package co.gov.sijac.admin.lugares.dao.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import co.gov.sijac.admin.lugares.dao.CiudadDAO;
import co.gov.sijac.admin.lugares.model.entidades.Ciudad;
import co.gov.sijac.common.annotation.GestorEntidad;
import co.gov.sijac.common.dao.impl.GenericoDAO;

/**
 * Session Bean implementation class CiudadDAO
 */
@Stateless
@Local(CiudadDAO.class)
@GestorEntidad(clase="CiudadDAOImpl",descripcion="Gestiona Ciudad del sistema")
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class CiudadDAOImpl extends GenericoDAO<Ciudad> implements CiudadDAO {

	@Inject
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public CiudadDAOImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public EntityManager getEntityManager() {
	return em;
	}

}