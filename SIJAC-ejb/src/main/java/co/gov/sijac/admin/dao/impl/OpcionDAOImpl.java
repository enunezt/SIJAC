package co.gov.sijac.admin.dao.impl;


import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import co.gov.sijac.admin.dao.OpcionDAO;
import co.gov.sijac.admin.model.entidades.Opcion;
import co.gov.sijac.common.annotation.GestorEntidad;
import co.gov.sijac.common.dao.impl.GenericoDAO;

/**
 * Session Bean implementation class GEPerfil
 */
@Stateless
@Local(OpcionDAO.class)
@GestorEntidad(clase="OpcionDAOImpl",descripcion="Gestiona las Opciones del sistema")
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class OpcionDAOImpl extends GenericoDAO<Opcion> implements OpcionDAO {

	@Inject
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public OpcionDAOImpl() {
        // TODO Auto-generated constructor stub
    }

	
	@Override
	public EntityManager getEntityManager() {
		return em;
	}

	

}
