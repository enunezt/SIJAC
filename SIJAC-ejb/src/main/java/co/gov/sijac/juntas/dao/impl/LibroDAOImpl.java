 
	
package co.gov.sijac.juntas.dao.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import co.gov.sijac.juntas.dao.LibroDAO;
import co.gov.sijac.juntas.model.entidades.Libro;
import co.gov.sijac.common.annotation.GestorEntidad;
import co.gov.sijac.common.dao.impl.GenericoDAO;

/**
 * Session Bean implementation class LibroDAO
 */
@Stateless
@Local(LibroDAO.class)
@GestorEntidad(clase="LibroDAOImpl",descripcion="Gestiona Libro del sistema")
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class LibroDAOImpl extends GenericoDAO<Libro> implements LibroDAO {

	@Inject
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public LibroDAOImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public EntityManager getEntityManager() {
	return em;
	}

}