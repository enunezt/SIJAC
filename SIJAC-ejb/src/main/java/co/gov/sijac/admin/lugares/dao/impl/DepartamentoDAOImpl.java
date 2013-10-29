 
	
package co.gov.sijac.admin.lugares.dao.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import co.gov.sijac.admin.lugares.dao.DepartamentoDAO;
import co.gov.sijac.admin.lugares.model.entidades.Departamento;
import co.gov.sijac.common.annotation.GestorEntidad;
import co.gov.sijac.common.dao.impl.GenericoDAO;

/**
 * Session Bean implementation class DepartamentoDAO
 */
@Stateless
@Local(DepartamentoDAO.class)
@GestorEntidad(clase="DepartamentoDAOImpl",descripcion="Gestiona Departamento del sistema")
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class DepartamentoDAOImpl extends GenericoDAO<Departamento> implements DepartamentoDAO {

	@Inject
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public DepartamentoDAOImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public EntityManager getEntityManager() {
	return em;
	}

}