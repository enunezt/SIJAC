 
	
package co.gov.sijac.juntas.dao.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import co.gov.sijac.juntas.dao.PersonaDAO;
import co.gov.sijac.juntas.model.entidades.Persona;
import co.gov.sijac.common.annotation.GestorEntidad;
import co.gov.sijac.common.dao.impl.GenericoDAO;

/**
 * Session Bean implementation class PersonaDAO
 */
@Stateless
@Local(PersonaDAO.class)
@GestorEntidad(clase="PersonaDAOImpl",descripcion="Gestiona Persona del sistema")
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class PersonaDAOImpl extends GenericoDAO<Persona> implements PersonaDAO {

	@Inject
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public PersonaDAOImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public EntityManager getEntityManager() {
	return em;
	}

}