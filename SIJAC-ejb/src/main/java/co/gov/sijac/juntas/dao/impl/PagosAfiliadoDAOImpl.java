 
	
package co.gov.sijac.juntas.dao.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import co.gov.sijac.juntas.dao.PagosAfiliadoDAO;
import co.gov.sijac.juntas.model.entidades.PagosAfiliado;
import co.gov.sijac.common.annotation.GestorEntidad;
import co.gov.sijac.common.dao.impl.GenericoDAO;

/**
 * Session Bean implementation class PagosAfiliadoDAO
 */
@Stateless
@Local(PagosAfiliadoDAO.class)
@GestorEntidad(clase="PagosAfiliadoDAOImpl",descripcion="Gestiona PagosAfiliado del sistema")
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class PagosAfiliadoDAOImpl extends GenericoDAO<PagosAfiliado> implements PagosAfiliadoDAO {

	@Inject
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public PagosAfiliadoDAOImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public EntityManager getEntityManager() {
	return em;
	}

}